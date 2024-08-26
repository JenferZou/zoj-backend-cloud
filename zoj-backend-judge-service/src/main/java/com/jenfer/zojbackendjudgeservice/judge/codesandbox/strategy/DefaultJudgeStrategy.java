package com.jenfer.zojbackendjudgeservice.judge.codesandbox.strategy;

import cn.hutool.json.JSONUtil;
import com.jenfer.zojbackendmodel.codesandbox.JudgeInfo;
import com.jenfer.zojbackendmodel.dto.question.JudgeCase;
import com.jenfer.zojbackendmodel.dto.question.JudgeConfig;
import com.jenfer.zojbackendmodel.entity.Question;
import com.jenfer.zojbackendmodel.enums.JudgeInfoMessageEnum;

import java.util.List;

public class DefaultJudgeStrategy implements JudgeStrategy{

    @Override
    public JudgeInfo doJudge(JudgeContext judgeContext) {
        JudgeInfo judgeInfo = judgeContext.getJudgeInfo();
        List<String> inputList = judgeContext.getInputList();
        List<String> outputList = judgeContext.getOutputList();
        List<JudgeCase> judgeCaseList = judgeContext.getJudgeCaseList();
        Question question = judgeContext.getQuestion();
        JudgeInfoMessageEnum judgeInfoMessageEnum = JudgeInfoMessageEnum.ACCEPTED;
        //先获取沙箱的实际执行信息
        Long memory = judgeInfo.getMemory();
        Long time = judgeInfo.getTime();
        JudgeInfo judgeInfoResponse = new JudgeInfo();
        judgeInfoResponse.setMemory(memory);
        judgeInfoResponse.setTime(time);
        judgeInfoResponse.setMessage(judgeInfoMessageEnum.getValue());

        //先进行结果数量比对
        if(outputList.size() != inputList.size()){
            //设置判题状态信息为错误答案
            judgeInfoMessageEnum = JudgeInfoMessageEnum.WRONG_ANSWER;
            judgeInfoResponse.setMessage(judgeInfoMessageEnum.getValue());
            return judgeInfoResponse;
        }

        //进行结果比对
        for(int i=0;i<judgeCaseList.size();i++){
            if(!judgeCaseList.get(i).getOutput().equals(outputList.get(i))){
                //设置判题状态信息为错误答案
                judgeInfoMessageEnum = JudgeInfoMessageEnum.WRONG_ANSWER;
                judgeInfoResponse.setMessage(judgeInfoMessageEnum.getValue());
                return judgeInfoResponse;
            }
        }

        //判断题目限制
        //获取原本题目期望的执行信息
        String judgeConfigStr = question.getJudgeConfig();
        JudgeConfig judgeConfig = JSONUtil.toBean(judgeConfigStr, JudgeConfig.class);
        Long needMemoryLimit = judgeConfig.getMemoryLimit();
        Long needTimeLimit = judgeConfig.getTimeLimit();
        if(memory > needMemoryLimit){
            judgeInfoMessageEnum = JudgeInfoMessageEnum.MEMORY_LIMIT_EXCEEDED;
            judgeInfoResponse.setMessage(judgeInfoMessageEnum.getValue());
            return judgeInfoResponse;
        }
        if(time > needTimeLimit){
            judgeInfoMessageEnum = JudgeInfoMessageEnum.TIME_LIMIT_EXCEEDED;
            judgeInfoResponse.setMessage(judgeInfoMessageEnum.getValue());
            return judgeInfoResponse;
        }

        return judgeInfoResponse;
    }
}

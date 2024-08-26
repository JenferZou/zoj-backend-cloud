package com.jenfer.zojbackendjudgeservice.judge.codesandbox.strategy;


import com.jenfer.zojbackendmodel.codesandbox.JudgeInfo;
import com.jenfer.zojbackendmodel.dto.question.JudgeCase;
import com.jenfer.zojbackendmodel.entity.Question;
import com.jenfer.zojbackendmodel.entity.QuestionSubmit;
import lombok.Data;

import java.util.List;

@Data
public class JudgeContext {
    private JudgeInfo judgeInfo;

    private List<String> inputList;

    private List<String> outputList;

    private Question question;

    private QuestionSubmit questionSubmit;

    private List<JudgeCase> judgeCaseList;

}

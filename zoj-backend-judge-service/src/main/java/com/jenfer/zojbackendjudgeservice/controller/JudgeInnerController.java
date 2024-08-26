package com.jenfer.zojbackendjudgeservice.controller;

import com.jenfer.zojbackendjudgeservice.judge.JudgeService;
import com.jenfer.zojbackendmodel.entity.QuestionSubmit;
import com.jenfer.zojbackendserviceclient.service.JudgeFeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/inner")
public class JudgeInnerController implements JudgeFeignClient {

    @Resource
    private JudgeService judgeService;

    @Override
    @PostMapping("/do")
    public QuestionSubmit doJudge(long questionSubmitId) {
        return judgeService.doJudge(questionSubmitId);
    }
}

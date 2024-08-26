package com.jenfer.zojbackendjudgeservice.judge.codesandbox.strategy;

import com.jenfer.zojbackendmodel.codesandbox.JudgeInfo;
import org.springframework.stereotype.Service;

@Service
public interface JudgeStrategy {
    JudgeInfo doJudge(JudgeContext judgeContext);
}

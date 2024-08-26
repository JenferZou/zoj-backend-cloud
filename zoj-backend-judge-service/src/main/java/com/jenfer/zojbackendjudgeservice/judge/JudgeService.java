package com.jenfer.zojbackendjudgeservice.judge;

import com.jenfer.zojbackendmodel.entity.QuestionSubmit;
import org.springframework.stereotype.Service;

@Service
public interface JudgeService {
    QuestionSubmit doJudge(long questionSubmitId);
}

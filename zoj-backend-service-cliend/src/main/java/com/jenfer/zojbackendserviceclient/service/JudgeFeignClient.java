package com.jenfer.zojbackendserviceclient.service;


import com.jenfer.zojbackendmodel.entity.QuestionSubmit;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "zoj-backend-judge-service",path = "/api/judge")
public interface JudgeFeignClient {

    @PostMapping("/do")
    QuestionSubmit doJudge(@RequestBody  long questionSubmitId);
}

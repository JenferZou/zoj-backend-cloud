package com.jenfer.zojbackendserviceclient.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jenfer.zojbackendmodel.dto.question.QuestionQueryRequest;
import com.jenfer.zojbackendmodel.entity.Question;
import com.jenfer.zojbackendmodel.entity.QuestionSubmit;
import com.jenfer.zojbackendmodel.vo.QuestionVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
* @author Jenf
* @description 针对表【question(题目)】的数据库操作Service
* @createDate 2024-08-19 17:11:47
*/
@FeignClient(name = "zoj-backend-question-service",path = "/api/question/inner")
public interface QuestionFeignClient {


    @GetMapping("/get/id")
    Question getQuestionById(@RequestParam("questionId") long questionId);

    @GetMapping("/question_submit/get/id")
    QuestionSubmit getQuestionSubmitById(@RequestParam("questionSubmitId") long questionSubmitId);

    @PostMapping("/question_submit/update")
    boolean updateQuestionSubmitById(@RequestBody QuestionSubmit questionSubmit);


}

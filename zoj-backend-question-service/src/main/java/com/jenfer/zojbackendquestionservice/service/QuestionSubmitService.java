package com.jenfer.zojbackendquestionservice.service;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jenfer.zojbackendmodel.dto.questionSubmit.QuestionSubmitAddRequest;
import com.jenfer.zojbackendmodel.dto.questionSubmit.QuestionSubmitQueryRequest;
import com.jenfer.zojbackendmodel.entity.QuestionSubmit;
import com.jenfer.zojbackendmodel.entity.User;
import com.jenfer.zojbackendmodel.vo.QuestionSubmitVO;
import org.springframework.stereotype.Service;

/**
* @author Jenf
* @description 针对表【question_submit(题目提交)】的数据库操作Service
* @createDate 2024-08-19 17:11:48
*/
@Service
public interface QuestionSubmitService extends IService<QuestionSubmit> {

    /**
     * 提交题目信息
     * @param questionSubmitAddRequest
     * @param loginUser
     * @return
     */
    long doQuestionSubmit(QuestionSubmitAddRequest questionSubmitAddRequest, User loginUser);



    /**
     * 获取查询条件
     *
     * @param questionSubmitQueryRequest
     * @return
     */
    QueryWrapper<QuestionSubmit> getQueryWrapper(QuestionSubmitQueryRequest questionSubmitQueryRequest);



    /**
     * 获取问题封装
     *
     * @param questionSubmit
     * @param loginUser
     * @return
     */
    QuestionSubmitVO getQuestionSubmitVO(QuestionSubmit questionSubmit, User loginUser);

    /**
     * 分页获取问题封装
     *
     * @param questionSubmitPage
     * @param loginUser
     * @return
     */
    Page<QuestionSubmitVO> getQuestionSubmitVOPage(Page<QuestionSubmit> questionSubmitPage, User loginUser);
}

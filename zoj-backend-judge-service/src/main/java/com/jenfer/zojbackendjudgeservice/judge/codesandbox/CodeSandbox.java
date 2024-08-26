package com.jenfer.zojbackendjudgeservice.judge.codesandbox;


import com.jenfer.zojbackendmodel.codesandbox.ExecuteCodeRequest;
import com.jenfer.zojbackendmodel.codesandbox.ExecuteCodeResponse;
import org.springframework.stereotype.Service;

@Service
public interface CodeSandbox {

    ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequestion);

}

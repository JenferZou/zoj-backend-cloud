package com.jenfer.zojbackendjudgeservice.judge.codesandbox;


import com.jenfer.zojbackendmodel.codesandbox.ExecuteCodeRequest;
import com.jenfer.zojbackendmodel.codesandbox.ExecuteCodeResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CodeSandboxProxy implements CodeSandbox {


    private final CodeSandbox codeSandbox;

    public CodeSandboxProxy(CodeSandbox codeSandbox) {
        this.codeSandbox = codeSandbox;
    }


    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequestion) {
        log.info("代码沙箱请求的参数：{}", executeCodeRequestion);
        ExecuteCodeResponse executeCodeResponse = codeSandbox.executeCode(executeCodeRequestion);
        log.info("代码沙箱返回的参数：{}", executeCodeResponse);
        return executeCodeResponse;
    }
}

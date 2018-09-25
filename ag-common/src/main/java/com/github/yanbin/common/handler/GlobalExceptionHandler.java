package com.github.yanbin.common.handler;


import com.github.yanbin.common.constants.CommonConstants;
import com.github.yanbin.common.exception.BaseException;
import com.github.yanbin.common.vo.BaseResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

@ControllerAdvice("com.github.yanbin")
@ResponseBody
public class GlobalExceptionHandler {

    @ExceptionHandler(BaseException.class)
    public BaseResponse baseExceptionHandler(HttpServletResponse reponse, BaseException ex){
        return new BaseResponse(ex.getStatus(),ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public BaseResponse otherexceptionHandler(HttpServletResponse response,Exception ex){
        return new BaseResponse(CommonConstants.EX_OTHER_CODE,ex.getMessage());
    }
}

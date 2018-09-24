package com.github.yanbin.common.exception.auth;

import com.github.yanbin.common.constants.CommonConstants;
import com.github.yanbin.common.exception.BaseException;

public class TokenErrorException extends BaseException {

    public TokenErrorException(String message, int status) {
        super(message, CommonConstants.EX_TOKEN_ERROR_CODE);
    }
}

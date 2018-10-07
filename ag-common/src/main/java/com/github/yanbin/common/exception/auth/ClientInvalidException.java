package com.github.yanbin.common.exception.auth;

import com.github.yanbin.common.constants.CommonConstants;
import com.github.yanbin.common.exception.BaseException;

public class ClientInvalidException extends BaseException {
    public ClientInvalidException(String message) {
        super(message, CommonConstants.EX_CLIENT_INVALID_CODE);
    }
}

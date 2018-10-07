package com.github.yanbin.common.exception.auth;

import com.github.yanbin.common.constants.CommonConstants;
import com.github.yanbin.common.exception.BaseException;

public class ClientForbiddenException extends BaseException {
    public ClientForbiddenException(String message) {
        super(message, CommonConstants.EX_CLIENT_FORBIDDEN_CODE);
    }
}

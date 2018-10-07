package com.github.yanbin.common.exception.auth;

import com.github.yanbin.common.constants.CommonConstants;
import com.github.yanbin.common.exception.BaseException;

public class UserInvalidException extends BaseException {
    public UserInvalidException(String message) {
        super(message, CommonConstants.EX_USER_INVALID_CODE);
    }
}

package com.github.yanbin.auth.service.impl;


import com.github.yanbin.auth.bean.UserInfo;

import com.github.yanbin.auth.service.UserService;
import com.github.yanbin.common.exception.auth.UserInvalidException;
import org.springframework.stereotype.Service;

@Service
public class LocalUserService implements UserService {
    @Override
    public UserInfo login(String username, String password) {
        UserInfo localInfo =new UserInfo(username,"管理员","1","123456");
        if(!localInfo.getPassword().equals(password)){
            throw new UserInvalidException("User password error");
        }
        return localInfo;
    }
}

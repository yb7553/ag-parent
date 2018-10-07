package com.github.yanbin.auth.service;

import com.github.yanbin.auth.bean.UserInfo;

public interface UserService {
    UserInfo login(String username, String password);
}

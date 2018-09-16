package com.github.yanbin.uc.rest;

import com.github.yanbin.common.rest.BaseController;
import com.github.yanbin.uc.biz.BaseUserBiz;
import com.github.yanbin.uc.entity.BaseUser;
import com.github.yanbin.uc.mapper.BaseUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserRest extends BaseController<BaseUserBiz,BaseUser> {

}

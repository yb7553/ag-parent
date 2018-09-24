package com.github.yanbin.uc.biz;

import com.github.yanbin.common.biz.BaseBiz;
import com.github.yanbin.common.exception.BaseException;
import com.github.yanbin.uc.dao.BaseUserDao;
import com.github.yanbin.uc.entity.BaseUser;
import com.github.yanbin.uc.mapper.BaseUserMapper;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author YB
 * @Date: 2018/9/15 10:45
 */


@Service
@Transactional
public class BaseUserBiz extends BaseBiz<BaseUserMapper,BaseUser> {


}

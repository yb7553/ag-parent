package com.github.yanbin.uc.biz;

import com.github.yanbin.uc.dao.BaseUserDao;
import com.github.yanbin.uc.entity.BaseUser;
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
public class BaseUserBiz {

    @Autowired
    private BaseUserDao baseUserDao;
    
    public int deleteByPrimaryKey(Object o) {
        return 0;
    }

    public int delete(BaseUser baseUser) {
        return 0;
    }

    public int insert(BaseUser baseUser) {
        return 0;
    }

    public int insertSelective(BaseUser baseUser) {
        return 0;
    }

    public boolean existsWithPrimaryKey(Object o) {
        return false;
    }

    public List<BaseUser> selectAll() {
        return null;
    }

    public BaseUser selectByPrimaryKey(Object o) {

        return baseUserDao.selectByPrimaryKey(o);
    }

    public int selectCount(BaseUser baseUser) {
        return 0;
    }

    public List<BaseUser> select(BaseUser baseUser) {
        return null;
    }

    public BaseUser selectOne(BaseUser baseUser) {
        return null;
    }

    public int updateByPrimaryKey(BaseUser baseUser) {
        return 0;
    }

    public int updateByPrimaryKeySelective(BaseUser baseUser) {
        return 0;
    }

    public int deleteByExample(Object o) {
        return 0;
    }

    
    public List<BaseUser> selectByExample(Object o) {
        return null;
    }

    public int selectCountByExample(Object o) {
        return 0;
    }

    public int updateByExample(BaseUser baseUser, Object o) {
        return 0;
    }

    public int updateByExampleSelective(BaseUser baseUser, Object o) {
        return 0;
    }

    
    public List<BaseUser> selectByExampleAndRowBounds(Object o, RowBounds rowBounds) {
        return null;
    }

    public List<BaseUser> selectByRowBounds(BaseUser baseUser, RowBounds rowBounds) {
        return null;
    }
}

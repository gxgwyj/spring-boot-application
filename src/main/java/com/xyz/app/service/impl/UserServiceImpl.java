package com.xyz.app.service.impl;

import com.xyz.app.dao.CsUserMapper;
import com.xyz.app.entity.CsUser;
import com.xyz.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Lenovo on 2018/1/6.
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    CsUserMapper csUserMapper;

    @Override
    public CsUser findUserById(Long userId) {
        return csUserMapper.selectByPrimaryKey(userId);
    }

    @Override
    public void addUser(CsUser user) {
        csUserMapper.insertSelective(user);
    }

    @Override
    public void updateUser(CsUser user) {
        csUserMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public List<CsUser> findUserList(CsUser user) {
        return csUserMapper.selectByWhere(user);
    }

}

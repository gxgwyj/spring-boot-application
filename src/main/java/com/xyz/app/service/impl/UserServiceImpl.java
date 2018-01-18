package com.xyz.app.service.impl;

import com.xyz.app.dao.CsUserMapper;
import com.xyz.app.entity.CsUser;
import com.xyz.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Lenovo on 2018/1/6.
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    CsUserMapper csUserMapper;

    @Override
    public CsUser getUserById(Long userId) {
        return csUserMapper.selectByPrimaryKey(userId);
    }

}

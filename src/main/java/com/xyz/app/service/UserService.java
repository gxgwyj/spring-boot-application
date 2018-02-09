package com.xyz.app.service;

import com.xyz.app.entity.CsUser;

import java.util.List;

/**
 * Created by Lenovo on 2018/1/6.
 */
public interface UserService {
    /**
     * 获取用户信息
     * @param userId
     * @return
     */
    public CsUser findUserById(Long userId);

    /**
     * 添加用户信息
     * @param user
     */
    public void addUser(CsUser user);

    /**
     * 更新用户信息
     * @param user
     */
    public void updateUser(CsUser user);

    /**
     * 获取用户信息列表
     * @param user
     * @return
     */
    public List<CsUser> findUserList(CsUser user);
}

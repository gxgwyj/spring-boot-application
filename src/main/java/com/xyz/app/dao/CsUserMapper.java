package com.xyz.app.dao;

import com.xyz.app.entity.CsUser;

public interface CsUserMapper {
    int deleteByPrimaryKey(Long userId);

    int insert(CsUser record);

    int insertSelective(CsUser record);

    CsUser selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(CsUser record);

    int updateByPrimaryKey(CsUser record);
}
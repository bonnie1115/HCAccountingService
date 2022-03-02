package com.hardcore.accounting.dao;

import com.hardcore.accounting.dao.mapper.UserInfoMapper;
import com.hardcore.accounting.model.persistence.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository //？？分装存储 描述dao??
public class UserInfoDAOImpl implements UserInfoDAO{

    private final UserInfoMapper userInfoMapper;

    @Autowired
    public UserInfoDAOImpl(UserInfoMapper userInfoMapper) {
        this.userInfoMapper = userInfoMapper;
    }


    @Override
   public UserInfo getUserInfoById(Long id) {
        return userInfoMapper.getUserInfoByUserId(id);
    }

    @Override
    public void createNewUser(String username, String password) {

    }
}

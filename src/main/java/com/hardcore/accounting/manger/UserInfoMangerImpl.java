package com.hardcore.accounting.manger;

import com.hardcore.accounting.converter.p2s.UserInfoP2SConverter;
import com.hardcore.accounting.dao.UserInfoDAO;
import com.hardcore.accounting.exception.ResourceNotFoundException;
import com.hardcore.accounting.model.common.UserInfo;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserInfoMangerImpl implements UserInfoManger {


    private final UserInfoDAO userInfoDAO;
    //转换的注入进来 1223
    private final UserInfoP2SConverter userInfoP2SConverter; //注意此处是p2s里的。manger这层不好区分，既要向数据库层转换又要向service层转换

    @Autowired  //注入？  不推荐这个方式，推荐用构造器注入
    public UserInfoMangerImpl(final UserInfoDAO userInfoDAO,
                               final UserInfoP2SConverter userInfoP2SConverter) {

        this.userInfoDAO = userInfoDAO;
        this.userInfoP2SConverter = userInfoP2SConverter;
    }


    @Override //p转换成c
    public UserInfo getUserInfoByUserId(Long userId){
        //val userInfo= userInfoDAO.getUserInfoById(userId);
        val userInfo = Optional.ofNullable(userInfoDAO.getUserInfoById(userId))
                                         .orElseThrow(() -> new ResourceNotFoundException(
                                String.format("user %s not found",userId)
                ));
        return  userInfoP2SConverter.convert(userInfo);
        //又要从common转换成Dao层怎么操作？


    }
}

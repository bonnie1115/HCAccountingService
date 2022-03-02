package com.hardcore.accounting.controller;

import com.hardcore.accounting.converter.c2s.UserInfoC2SConverter;
import com.hardcore.accounting.manger.UserInfoManger;
import com.hardcore.accounting.model.service.UserInfo;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//hostnam:port/v1/user/....
@RestController
@RequestMapping("v1/users")  //相当于每个请求前加v1/users

public class UserController {

    //  1.不要有过多的逻辑处理
   //  2.参数校验越早做越好（后端一定也要做校验，不要依赖前端）

    private final UserInfoManger userInfoManger;
    private final UserInfoC2SConverter userInfoC2SConverter;//注意此处是C2s

    @Autowired //？？
    public UserController(final UserInfoManger userInfoManger,
                          final UserInfoC2SConverter userInfoC2SConverter) {
        this.userInfoManger = userInfoManger;
        this.userInfoC2SConverter = userInfoC2SConverter;
    }


    @GetMapping("/{id}")//service model UserInfo
    public UserInfo getUserInfoByUserId(@PathVariable("id") Long userId) {
        //做校验
        //log.debug("get user info by user id {}",userId); //lombok打日志，首次使用需要配置下
        val userInfo =userInfoManger.getUserInfoByUserId(userId);
        return userInfoC2SConverter.convert(userInfo);

    }
}

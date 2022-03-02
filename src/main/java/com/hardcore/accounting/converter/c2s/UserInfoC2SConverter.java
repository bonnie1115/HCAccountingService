package com.hardcore.accounting.converter.c2s;

import com.google.common.base.Converter;
import com.hardcore.accounting.model.common.UserInfo;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class UserInfoConverter extends Converter<UserInfo, com.hardcore.accounting.model.service.UserInfo> {
    @Override
    protected com.hardcore.accounting.model.service.UserInfo doForward(UserInfo userInfo) {
        return com.hardcore.accounting.model.service.UserInfo.builder()
                .id(userInfo.getId())
                .username(userInfo.getUsername())
                .build();//????这是在干嘛？？


    }

    //前端传过来的，可以传密码，但是上面是后端返回的，应该不返回密码才对
    @Override
    protected UserInfo doBackward(com.hardcore.accounting.model.service.UserInfo userInfo) {
        return UserInfo.builder()
                .id(userInfo.getId())
                .password(userInfo.getPassword())
                .username(userInfo.getUsername())
                .build();
    }
}

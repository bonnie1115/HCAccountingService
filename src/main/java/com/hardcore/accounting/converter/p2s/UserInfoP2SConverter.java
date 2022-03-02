package com.hardcore.accounting.converter.p2s;

import com.google.common.base.Converter;
import com.hardcore.accounting.model.persistence.UserInfo;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component       //?
@NoArgsConstructor  //???不需要构造参数构造器 做converter的时候不要调用服务，不要调用操作数据库之类，这里单纯做数据转换
public class UserInfoP2SConverter extends Converter<UserInfo, com.hardcore.accounting.model.common.UserInfo> {

    @Override
    protected com.hardcore.accounting.model.common.UserInfo doForward(UserInfo userInfo) {
        return com.hardcore.accounting.model.common.UserInfo.builder()
                .id(userInfo.getId())
                .username(userInfo.getUsername())
                .password(userInfo.getPassword())
                .build();
    }

    //
    @Override
    protected UserInfo doBackward(com.hardcore.accounting.model.common.UserInfo userInfo) {
        return UserInfo.builder()
                .id(userInfo.getId())
                .username(userInfo.getUsername())
                .password(userInfo.getPassword())
                .build();
    }
}

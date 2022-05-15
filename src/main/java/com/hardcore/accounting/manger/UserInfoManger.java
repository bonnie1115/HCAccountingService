package com.hardcore.accounting.manger;

import com.hardcore.accounting.model.common.UserInfo;

//记住，这一层一定要写成接口，哪怕只有一个，也要写成接口
public interface UserInfoManger {
    UserInfo  getUserInfoByUserId(Long userId);
}

package com.hardcore.accounting.dao.mapper;

import com.hardcore.accounting.model.persistence.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserInfoMapper {
    //
     //怎么让mybits识别这个是一个mapper？用@select
    //用到持久化层的方法
    @Select("SELECT id, username, password, create_time, update_time FROM hcas_userinfo WHERE id = #{id}")
    UserInfo getUserInfoByUserId(@Param("id") Long id);
}

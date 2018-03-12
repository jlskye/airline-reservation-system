package com.mapper;

import com.bean.Userbean;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    //插入用户信息
    @Insert("insert into user_info(user_phone,user_id,user_name,user_email," +
            "user_salt,user_hash,user_money) values(#{user_phone},#{user_id}," +
            "#{user_name},#{user_email},#{user_salt},#{user_hash},#{user_money})")
    void insert(Userbean userbean);

    //根据手机号码判断用户是否存在
    @Select("SELECT COUNT(*) from user_info where user_info.user_phone = #{user_phone}")
    int isExistedByPhone(@Param("user_phone")String user_phone);


    //根据手机号码获取用户
    @Select("select * from user_info where user_info.user_phone = #{user_phone}")
    Userbean getUser(@Param("user_phone")String user_phone);






}

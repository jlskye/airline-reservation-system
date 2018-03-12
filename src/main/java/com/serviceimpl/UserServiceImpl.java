package com.serviceimpl;

import com.bean.Userbean;
import com.mapper.UserMapper;
import com.service.UserService;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.annotation.Resources;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;
    public void save(Userbean userbean) {
          userMapper.insert(userbean);
    }

    public int isExistedByphone(String user_phone){
       return userMapper.isExistedByPhone(user_phone);
    }

    public Userbean getUser(String user_phone){
        return userMapper.getUser(user_phone);
    }


}

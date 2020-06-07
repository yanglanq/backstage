package com.join.TinyProgram.service.userService.impl;

import com.join.TinyProgram.entity.diary.Diary;
import com.join.TinyProgram.entity.user.User;
import com.join.TinyProgram.mapper.diary.DiaryMapper;
import com.join.TinyProgram.mapper.userMapper.UserMapper;
import com.join.TinyProgram.service.userService.UserService;
import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Yangfn
 * @Description:
 * @Date: 22:21 2020/5/9
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;



    /**
     * 登录
     * @param user
     * @return
     * @throws Exception
     */
    @Override
    public int login(User user) throws Exception{
        return userMapper.addUser(user);
    }

    /**
     * 注册
     * @param user
     * @return
     * @throws Exception
     */
    @Override
    public int addUser(User user) throws Exception{
        return userMapper.addUser(user);
    }


    @Override
    public List<User> listAll()throws Exception{
        return userMapper.listUser();
    }
    @Override
    public List<User> queryUser(String openid)throws Exception{
        return userMapper.queryUser(openid);
    }

    @Override
    public int delete(int id)throws Exception{
        return userMapper.deleteUser(id);
    }

}

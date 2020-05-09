package com.join.TinyProgram.service.userService.impl;

import com.join.TinyProgram.entity.User;
import com.join.TinyProgram.mapper.userMapper.UserMapper;
import com.join.TinyProgram.service.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public User login(User user) throws Exception{
        return userMapper.login(user);
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

    /**
     * 修改个人信息
     * @param user
     * @return
     * @throws Exception
     */
    @Override
    public int update(User user) throws Exception{
        return userMapper.updateUser(user);
    }
    /**
     * 修改密码
     * @param user
     * @return
     * @throws Exception
     */
    @Override
    public int updatePassword(User user) throws Exception{
        return userMapper.updatePassword(user);
    }
    /**
     * 修改状态
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public int updateStatus(int id,int status) throws Exception{
        return userMapper.updateStatus(id,status);
    }
    @Override
    public List<User> listAll()throws Exception{
        return userMapper.listUser();
    }
    @Override
    public List<User> queryUser(String card)throws Exception{
        return userMapper.queryUser(card);
    }

    @Override
    public int delete(String card)throws Exception{
        return userMapper.deleteUser(card);
    }
    /**
     * 判断用户名
     * @param
     * @return
     * @throws Exception
     */
    @Override
    public boolean judgeUsername(String name) throws Exception{
        boolean b=true;
        List<User> list=userMapper.listUser();
        for(int i=0;i<list.size();i++){
            User user=list.get(i);
            if(user.getUsername().equals(name)){
                b=false;
                return b;
            }
        }
        return b;
    }
    /**
     * 上传头像
     * @param
     * @return
     * @throws Exception
     */
    @Override
    public int uploadHead(int id,String path,String headUrl) throws Exception{
        return userMapper.uploadHead(id,path,headUrl);

    }
}

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
import java.util.Arrays;
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
    @Autowired
    DiaryMapper diaryMapper;


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

//    /**
//     * 修改个人信息
//     * @param user
//     * @return
//     * @throws Exception
//     */
//    @Override
//    public int update(User user) throws Exception{
//        return userMapper.updateUser(user);
//    }

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
     * 上传头像
     * @param
     * @return
     * @throws Exception
     */
    @Override
    public int uploadHead(int id,String path,String headUrl) throws Exception{
        return userMapper.uploadHead(id,path,headUrl);

    }

    @Override
    public List<Diary> listDiary(int userId)throws Exception{
        return diaryMapper.listDiary(userId);
    }

    @Override
    public int addDiary(Diary diary)throws Exception{
        return diaryMapper.addDiary(diary);
        //return userMapper.updateDiary(diary);
    }
    @Override
    public int refresh(int id)throws Exception{
        List<Diary> list=diaryMapper.listDiary(id);
        System.out.println(list);
        ArrayList li = new ArrayList();
        for(int i = 0; i < list.size(); i++){
            Diary diary=list.get(i);
            li.add(String.valueOf(diary.getId()));
        }
        String str= StringUtils.join(li,',');
        return userMapper.updateDiary(id,str);
    }

    @Override
    public int deleteDiary(int id)throws Exception{
        return diaryMapper.deleteDiary(id);
    }
    @Override
    public int updateDiary(Diary diary)throws Exception{
        return diaryMapper.updateDiary(diary);
    }
}

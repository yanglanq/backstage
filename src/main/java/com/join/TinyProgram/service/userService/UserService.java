package com.join.TinyProgram.service.userService;

import com.join.TinyProgram.entity.diary.Diary;
import com.join.TinyProgram.entity.user.User;
import java.util.List;


/**
 * @Author: Yangfn
 * @Description:
 * @Date: 22:21 2020/5/9
 */
public interface UserService {

    public int login(User user) throws Exception;


    public List<User> listAll()throws Exception;

    public List<User> queryUser(String openid)throws Exception;

    public int delete(int id)throws Exception;

    public int addUser(User user)throws Exception;


}

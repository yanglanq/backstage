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
    public User login(User user) throws Exception;

//    public int update(User user) throws Exception;

    public int updateStatus(int id,int status) throws Exception;

    public List<User> listAll()throws Exception;

    public List<User> queryUser(String card)throws Exception;

    public int delete(String card)throws Exception;

    public int addUser(User user)throws Exception;

    public int uploadHead(int id,String path,String headUrl)throws Exception;


//    public int refresh(int id)throws Exception;
}

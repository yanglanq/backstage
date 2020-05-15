package com.join.TinyProgram.controller.user;

import com.join.TinyProgram.entity.diary.Diary;
import com.join.TinyProgram.entity.user.User;
import com.join.TinyProgram.service.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: Yangfn
 * @Description:
 * @Date: 21:40 2020/5/9
 */
@Controller
@CrossOrigin
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;


    @ResponseBody
    @RequestMapping("/listAll")
    public List<User> listAll()throws Exception{
        return userService.listAll();
    }
    /**
     *登录~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * @return
     * @throws Exception
     */
//    @RequestMapping("/login")
//    public User login(String username)throws Exception{
//            return userService.login(i);
//
//    }
    @ResponseBody
    @RequestMapping("/addUser")
    public int addUser(User user)throws Exception{
        return userService.addUser(user);
    }
    @ResponseBody
    @RequestMapping("/listDiary")
    public List<Diary> listDiary(int id)throws Exception{
        return userService.listDiary(id);
    }
    @ResponseBody
    @RequestMapping("/addDiary")
    public int addDiary(Diary diary)throws Exception{
        return userService.addDiary(diary)+userService.refresh(diary.getUserId());
    }
    @ResponseBody
    @RequestMapping("/refreshDiary")
    public int refreshDiary(int id)throws Exception{
        return userService.refresh(id);
    }
    @ResponseBody
    @RequestMapping("/deleteDiary")
    public int deleteDiary(int id)throws Exception{
        return userService.deleteDiary(id);
    }
    @ResponseBody
    @RequestMapping("/updateDiary")
    public int updateDiary(Diary diary)throws Exception{
         return userService.updateDiary(diary);
    }

}

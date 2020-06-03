package com.join.TinyProgram.controller.user;

import com.join.TinyProgram.entity.diary.Diary;
import com.join.TinyProgram.entity.user.User;
import com.join.TinyProgram.service.userService.UserService;
import com.join.TinyProgram.utils.img.ImgUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
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


//    @ResponseBody
//    @RequestMapping("/refreshDiary")
//    public int refreshDiary(int id)throws Exception{
//        return userService.refresh(id);
//    }


}

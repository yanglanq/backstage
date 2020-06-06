package com.join.TinyProgram.test;

import com.join.TinyProgram.controller.user.UserController;
import com.join.TinyProgram.entity.diary.Diary;
import com.join.TinyProgram.entity.user.User;
import com.join.TinyProgram.service.diaryService.DiaryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

/**
 * @Author: Yangfn
 * @Description:
 * @Date: 22:55 2020/5/9
 */
@SpringBootTest
public class UserTest {
    @Autowired
    UserController userController;

    @Autowired
    DiaryService diaryService;
//    @Test
//    public void listAllTest()throws Exception {
//        System.out.println(userController.listDiary(1));
//
//    }
    @Test
    public void addDiaryTest()throws Exception {
        Diary diary=new Diary();
        Date date=new Date();
        diary.setBid(2);
        diary.setDate(date);
        diary.setTitle("test22");
        diaryService.addDiary(diary);
        System.out.println(diary.getId());


    }
//    @Test
//    public void refreshTest()throws Exception {
//        int id=1;
//        System.out.println(userController.refreshDiary(id));
//
//    }
//    @Test
//    public void updateDiaryTest()throws Exception {
//        Diary diary=new Diary();
//        Date date=new Date();
//        diary.setId(2);
//        diary.setBid(1);
//        diary.setDate(date);
//        diary.setTitle("happy");
//        System.out.println(userController.updateDiary(diary));
//
//    }
//    @Test
//    public void addUserTest()throws Exception {
//        User user=new User();
//        user.setUsername("yfn2");
//        user.setSex("女");
//        System.out.println(userController.addUser(user));
//
//    }
}

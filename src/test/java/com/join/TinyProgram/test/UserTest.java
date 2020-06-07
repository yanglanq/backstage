package com.join.TinyProgram.test;

import com.join.TinyProgram.controller.user.UserController;
import com.join.TinyProgram.entity.book.Book;
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
    @Test
    public void loginTest()throws Exception {
        String code="1234";
        System.out.println(userController.login(code));

    }
    @Test
    public void addBookTest()throws Exception {
        Book book=new Book();
        book.setName("test");
        book.setUid(1);
        Date date=new Date();
        book.setDate(date);
        System.out.println(diaryService.addBook(book));

    }
    @Test
    public void addUserTest()throws Exception {
        User user=new User();
        user.setId(1);
        user.setUsername("yfn2");
        user.setHeadUrl("url");
        user.setSex("女");
        System.out.println(userController.addUser(user));

    }
}

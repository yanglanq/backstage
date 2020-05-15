package com.join.TinyProgram.test;

import com.join.TinyProgram.controller.user.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author: Yangfn
 * @Description:
 * @Date: 22:55 2020/5/9
 */
@SpringBootTest
public class UserTest {
    @Autowired
    UserController userController;
    @Test
    public void listAllTest()throws Exception {
        System.out.println(userController.listDiary(1));

    }
}

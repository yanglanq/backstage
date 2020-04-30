package com.join.TinyProgram.controller.msg;

import com.join.TinyProgram.service.msgService.msgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * author dongml
 * time 29/4/2020
 * description
 */
@Controller
@CrossOrigin
@RequestMapping("/msg")
public class msgController {
    @Autowired
    private msgService msgservice;

    @ResponseBody
    @RequestMapping("/getAll")
    public Object getAll(Integer integer){
        if(integer == 1){
            System.out.println("可以传参数！");
        }
        return msgservice.getAll();
    }
}

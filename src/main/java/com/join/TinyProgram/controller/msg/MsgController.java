package com.join.TinyProgram.controller.msg;

import com.join.TinyProgram.entity.msg.Msg;
import com.join.TinyProgram.entity.pic.Pic;
import com.join.TinyProgram.service.msgService.MsgService;
import com.join.TinyProgram.service.picService.PicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * author dongml
 * time 3/6/2020
 * description
 */
@Controller
@CrossOrigin
@RequestMapping("/msg")
public class MsgController {
    Msg msg = new Msg();

    @Autowired
    private MsgService msgService;

    @Autowired
    private PicService picService;

    @ResponseBody
    @RequestMapping("/getAll")
    public List<Msg> getAll(){
        return msgService.getAll();
    }

    @ResponseBody
    @RequestMapping("/userGetMsg")
    public Msg userGetMsg(){
        return msg;
    }

    @Scheduled(cron = "0 6 * * *")
    @ResponseBody
    @RequestMapping("/getByRand")
    public Msg getByRand(){
        msg = picService.getByRand();
        return msg;
    }

    @ResponseBody
    @RequestMapping("/addNew")
    public boolean addNew(String msg){
        if(msg == null){
            return false;
        }
        return msgService.addNew(msg);
    }

    @ResponseBody
    @RequestMapping("/delete")
    public boolean delete(Integer id){
        return msgService.delete(id);
    }

    @ResponseBody
    @RequestMapping("/update")
    public boolean update(String msg,Integer id){
        return msgService.update(msg, id);
    }
}

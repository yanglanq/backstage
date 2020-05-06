package com.join.TinyProgram.controller.succulent;

import com.join.TinyProgram.entity.Succulent;
import com.join.TinyProgram.service.succulentService.SucculentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * author dongml
 * time 6/5/2020
 * description
 */
@Controller
@CrossOrigin
@RequestMapping("/succulent")
public class SucculentController {

    @Autowired
    SucculentService succulentService;

    @ResponseBody
    @RequestMapping("/getAll")
    public List<Succulent> getAll() {
        try{
            return succulentService.getAll();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @ResponseBody
    @RequestMapping("addNew")
    public Object addNew(Succulent succulent){
        try{
            if(succulent.getPname().equals("")){
                return false;
            }else {
                try{
                    return succulentService.addNew(succulent);
                }catch (Exception e) {
                    e.printStackTrace();
                    return false;
                }
            }
        }catch (NullPointerException e){
            return false;
        }
    }
}

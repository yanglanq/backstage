package com.join.TinyProgram.controller.succulent;

import com.github.pagehelper.PageInfo;
import com.join.TinyProgram.entity.Succulent;
import com.join.TinyProgram.service.succulentService.SucculentService;
import com.join.TinyProgram.utils.resultHander.CommonErrorEnum;
import com.join.TinyProgram.utils.resultHander.ResponseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    @RequestMapping("/addNew")
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

    @ResponseBody
    @RequestMapping("/getByPage")
    public Object getSucculentByPage(@RequestParam(value = "pageNum",defaultValue = "1")Integer pageNum, @RequestParam(value = "size",defaultValue = "10")Integer size){
        try {
            return new ResponseBean(true,succulentService.getSucculentByPage(pageNum,size));
        }catch (Exception e){
            return new ResponseBean(false, CommonErrorEnum.FAIL_GETDATA);
        }
    }

    @ResponseBody
    @RequestMapping("/searchByWord")
    public Object searchByword(String feature){
        try{
            Succulent succulent = new Succulent();
            succulent.setFeature(feature);
            return new ResponseBean(true,succulentService.searchByword(succulent));
        }catch (NullPointerException e){
            return new ResponseBean(false,CommonErrorEnum.DATABASE_ERROR);
        }
    }
}

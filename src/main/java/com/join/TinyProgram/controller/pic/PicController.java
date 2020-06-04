package com.join.TinyProgram.controller.pic;

import com.join.TinyProgram.entity.pic.Pic;
import com.join.TinyProgram.service.picService.PicService;
import com.join.TinyProgram.utils.img.ImgUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * author dongml
 * time 4/6/2020
 * description
 */
@CrossOrigin
@Controller
@RequestMapping("/pic")
public class PicController {

    @Autowired
    private PicService picService;

    @ResponseBody
    @RequestMapping("/getAll")
    public List<Pic> getAll(){
        return picService.getAll();
    }

    @ResponseBody
    @RequestMapping("/addNew")
    public boolean addNew(MultipartFile pic,String intro,Integer num){
        String path="/www/wwwroot/yanglq.xyz/images/succulentImg/pic/";
        String picUrl="/img/succulentImg/pic/";
        //本地：
//        String path="e:/dongml/pic/";
//        String picUrl="/img/pic/";
        ImgUploadUtil imgUploadUtil = new ImgUploadUtil();
        String filename = imgUploadUtil.imgUpload2(pic,path,picService.getIdPre());
        String file = picUrl + filename;
        return picService.addNew(file,intro,num);
    }

    @ResponseBody
    @RequestMapping("/delete")
    public boolean delete(Integer id,Integer num){
        return picService.delete(id, num);
    }

    @ResponseBody
    @RequestMapping("/update")
    boolean update(String url,Integer id,String intro,Integer num){
        return picService.update(url, id, intro, num);
    }
}

package com.join.TinyProgram.controller.succulent;

//import com.github.pagehelper.PageInfo;
import com.join.TinyProgram.entity.succulent.Succulent;
import com.join.TinyProgram.service.succulentService.SucculentService;
import com.join.TinyProgram.utils.img.FileUpload;
import com.join.TinyProgram.utils.img.ImgUploadUtil;
import com.join.TinyProgram.utils.resultHander.CommonErrorEnum;
import com.join.TinyProgram.utils.resultHander.ResponseBean;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public Map<Object,Object> addNew(MultipartFile img, String pname, String alias, String classification,
                                     String intro, String feature, String habits, String florescence){
        Succulent succulent = new Succulent();
        String path="/www/wwwroot/yanglq.xyz/images/succulentImg/succulent/";
        String picUrl="/img/succulentImg/succulent/";
        //本地：
//        String path="e:/dongml/SucculentImg/";
//        String picUrl="/img/SucculentImg/";
        Map<Object,Object> map = new HashMap<>();
        succulent.setPname(pname);
        succulent.setAlias(alias);
        succulent.setClassification(classification);
        succulent.setIntro(intro);
        succulent.setFeature(feature);
        succulent.setHabits(habits);
        succulent.setFlorescence(florescence);
        ImgUploadUtil uploadUtil = new ImgUploadUtil();
        String imgurl = uploadUtil.imgUpload(img,path);
        succulent.setImgUrl(picUrl+imgurl);
        if (imgurl == null){
            map.put(new String("msgOfImg"),new String("图片是空的"));
        }
        try{
            if(succulent.getPname().equals("")){
                map.put(new String("msg"),false);
            }else {
                try{
                    map.put(new String("data"),succulentService.addNew(succulent));
                }catch (Exception e) {
                    e.printStackTrace();
                    map.put(new String("msg"),false);
                }
            }
        }catch (NullPointerException e){
            map.put(new String("msg"),false);;
        }
        return map;
    }

    @ResponseBody
    @RequestMapping("/addNewWithoutFile")
    public Map<Object,Object> addNewWithoutFile(String url, String pname, String alias, String classification,
                                     String intro, String feature, String habits, String florescence){
        Succulent succulent = new Succulent();
        Map<Object,Object> map = new HashMap<>();
        succulent.setPname(pname);
        succulent.setAlias(alias);
        succulent.setClassification(classification);
        succulent.setIntro(intro);
        succulent.setFeature(feature);
        succulent.setHabits(habits);
        succulent.setFlorescence(florescence);
        String path="/www/wwwroot/yanglq.xyz/images/succulentImg/succulent/";
        String picUrl="/img/succulentImg/succulent/";
        //本地：
//        String path="e:/dongml/SucculentImg/";
//        String picUrl="/img/SucculentImg/";
        FileUpload fileUpload = new FileUpload();
        String url1 = fileUpload.getHtmlPicture(url,path,null);
        String finalurl = picUrl + url1;
        succulent.setImgUrl(finalurl);
        try{
            if(succulent.getPname().equals("")){
                map.put(new String("msg"),false);
            }else {
                try{
                    map.put(new String("data"),succulentService.addNew(succulent));
                }catch (Exception e) {
                    e.printStackTrace();
                    map.put(new String("msg"),false);
                }
            }
        }catch (NullPointerException e){
            map.put(new String("msg"),false);;
        }
        return map;
    }

//    @ResponseBody
//    @RequestMapping("/getByPage")
//    public Object getSucculentByPage(@RequestParam(value = "pageNum",defaultValue = "1")Integer pageNum, @RequestParam(value = "size",defaultValue = "10")Integer size){
//        try {
//            return new ResponseBean(true,succulentService.getSucculentByPage(pageNum,size));
//        }catch (Exception e){
//            return new ResponseBean(false, CommonErrorEnum.FAIL_GETDATA);
//        }
//    }

    @ResponseBody
    @RequestMapping("/searchByWord")
    public Object searchByword(String word){
        try{
            return new ResponseBean(true,succulentService.searchByword(word))  ;
        }catch (NullPointerException e){
            return new ResponseBean(false,CommonErrorEnum.DATABASE_ERROR);
        }
    }

    @ResponseBody
    @RequestMapping("/delete")
    public boolean delete(Integer id){
        return succulentService.delete(id);
    }

    @ResponseBody
    @RequestMapping("/update")
    boolean update(Integer plantid,String pname, String alias, String classification,
                   String intro, String feature, String habits, String florescence){
        Succulent succulent = new Succulent();
        succulent.setPlantid(plantid);
        succulent.setPname(pname);
        succulent.setAlias(alias);
        succulent.setClassification(classification);
        succulent.setIntro(intro);
        succulent.setFeature(feature);
        succulent.setHabits(habits);
        succulent.setFlorescence(florescence);
        return succulentService.update(succulent);
    }

    @ResponseBody
    @RequestMapping("/addSearch")
    public boolean addSearch(String word){
        return succulentService.addSearch(word);
    }

    @ResponseBody
    @RequestMapping("/getHotWord")
    public List<String> getHotWord(){
        return succulentService.getHotWord();
    }
}

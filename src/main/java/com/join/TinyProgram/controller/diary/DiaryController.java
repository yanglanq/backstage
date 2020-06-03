package com.join.TinyProgram.controller.diary;

import com.join.TinyProgram.entity.diary.Diary;
import com.join.TinyProgram.service.diaryService.DiaryService;
import com.join.TinyProgram.utils.img.ImgUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Author: Yangfn
 * @Description:
 * @Date: 0:02 2020/6/3
 */
@Controller
@CrossOrigin
@RequestMapping("/diary")
public class DiaryController {

    @Autowired
    DiaryService diaryService;


    @ResponseBody
    @RequestMapping("/listDiary")
    public List<Diary> listDiary(int id)throws Exception{
        return diaryService.listDiary(id);
    }

    @ResponseBody
    @RequestMapping("/deleteDiary")
    public int deleteDiary(int id)throws Exception{
        return diaryService.deleteDiary(id);
    }
    @ResponseBody
    @RequestMapping("/updateDiary")
    public int updateDiary(Diary diary)throws Exception{
        return diaryService.updateDiary(diary);
    }


    @ResponseBody
    @RequestMapping("/addDiary")
    public int addDiary(@RequestParam(value = "file") MultipartFile files[],Diary diary)throws Exception{
        ImgUploadUtil imgUploadUtil=new ImgUploadUtil();
        for(MultipartFile file:files){
            if (file.isEmpty()) {
                System.out.println("文件为空");
                break;
            }
            //String path="/www/wwwroot/yanglq.xyz/images/userImg/diary/";
            String path="e:/yfn/diary/";
            if (!imgUploadUtil.imgUpload(file,path)){
                return 0;
            }
        }
        return diaryService.addDiary(diary);
        //return 1;
    }
}

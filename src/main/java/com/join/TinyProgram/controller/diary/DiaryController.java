package com.join.TinyProgram.controller.diary;

import com.join.TinyProgram.entity.book.Book;
import com.join.TinyProgram.entity.diary.Diary;
import com.join.TinyProgram.entity.img.Img;
import com.join.TinyProgram.service.diaryService.DiaryService;
import com.join.TinyProgram.utils.img.ImgUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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
    @RequestMapping("/listBook")
    public List<Book> listBook(int uid)throws Exception{
        return diaryService.listBook(uid);
    }

    @ResponseBody
    @RequestMapping("/addBook")
    public int addBook(@RequestParam(value = "file") MultipartFile file,Book book)throws Exception{
        ImgUploadUtil imgUploadUtil=new ImgUploadUtil();
        String filename=null;
        if (file.isEmpty()) {
            System.out.println("文件为空");
        }
        //String path="/www/wwwroot/yanglq.xyz/images/userImg/diary/";
        //String picUrl="/img/userImg/diary/";
        String path="e:/yfn/diary/";
        String picUrl="/img/diary/";
        filename=imgUploadUtil.imgUpload(file,path);
        if (filename==null){
            return -1;
        }
        //diaryService.uploadHead(picUrl+filename,path+filename);
        book.setHeadUrl(picUrl+filename);
        book.setPath(path+filename);
        return diaryService.addBook(book);
    }

    @ResponseBody
    @RequestMapping("/updateBook")
    public int updateBook(Book book)throws Exception{
        return diaryService.updateBook(book);
    }

    @ResponseBody
    @RequestMapping("/deleteBook")
    public int deleteBook(int id)throws Exception{
        return diaryService.deleteBook(id);
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
    @RequestMapping(value = "/addDiary",method = RequestMethod.POST)
    public int addDiary(@RequestParam(value = "file") MultipartFile files[],Diary diary)throws Exception{
        Date date=new Date();
        int id=-1;
        diary.setDate(date);
        diaryService.addDiary(diary);
        id=diary.getId();
        if(id==0){
            return -2;
        }
        ImgUploadUtil imgUploadUtil=new ImgUploadUtil();
        String filename=null;
        for(MultipartFile file:files){
            if (file.isEmpty()) {
                System.out.println("文件为空");
                break;
            }
            //String path="/www/wwwroot/yanglq.xyz/images/userImg/diary/";
            //String picUrl="/img/userImg/diary/";
            //本地：
            String path="e:/yfn/diary/";
            String picUrl="/img/diary/";
            filename=imgUploadUtil.imgUpload(file,path);
            if (filename==null){
                return -1;
            }
            Img img=new Img(id,picUrl+filename,path+filename);
            diaryService.addImg(img);
        }
        return 1;
    }
}

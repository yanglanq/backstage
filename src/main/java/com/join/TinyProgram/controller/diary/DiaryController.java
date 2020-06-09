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

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
    @RequestMapping("/queryDiaryById")
    public Diary queryDiaryById(int id)throws Exception{
        return diaryService.queryDiaryById(id);
    }

    @ResponseBody
    @RequestMapping("/queryBookById")
    public Book queryBookById(int id)throws Exception{
        return diaryService.queryBookById(id);
    }

    @ResponseBody
    @RequestMapping("/listBook")
    public List<Book> listBook(int id)throws Exception{
        return diaryService.listBook(id);
    }

    @ResponseBody
    @RequestMapping("/listImg")
    public List<Img> listImg(int id)throws Exception{
        return diaryService.listImg(id);
    }

    @ResponseBody
    @RequestMapping("/refreshBook")
    public int freshBook(int id)throws Exception{
        return diaryService.freshBook(id);
    }

    @ResponseBody
    @RequestMapping("/addBook")
    public int addBook(Book book)throws Exception{
        Date date=new Date();
        book.setDate(date);
        return diaryService.addBook(book);
    }

    @ResponseBody
    @RequestMapping("/update")
    public int update(Book book)throws Exception{
        Date date=new Date();
        book.setDate(date);
        return diaryService.update(book);
    }

    @ResponseBody
    @RequestMapping("/watering")
    public List<Book> watering(int id)throws Exception{
        List<Book> list=diaryService.listBook(id);
        System.out.println(list);
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();
        String time=format.format(date);
        //System.out.println(time);
        List<Book> list1=new ArrayList<>();
       //time="08:25:00";

        for(Book book:list){
            //System.out.println(book);
            String w=book.getWatering();
            //System.out.println("1"+w);
            if(book.getWatering()!=null){
                //System.out.println(w);
                String s[]=time.split(":");
                String a[]=s[0].split("");
                int i=exchange(a[0])*10+exchange(a[1]);
                int i1=i-1;
                int i2=i+1;
                String l1=intExchange(i1)+":"+s[1]+":"+s[2];
                String l2=intExchange(i2)+":"+s[1]+":"+s[2];
                System.out.println(l1+"   "+l2);
                if(l1.compareTo(book.getWatering())<0
                        &&l2.compareTo(book.getWatering())>0){
                    list1.add(book);
                }

            }

        }
        return list1;
    }

    @ResponseBody
    @RequestMapping(value ="/updateBook",method = RequestMethod.POST)
    public int updateBook(@RequestParam(value = "file") MultipartFile file,Book book)throws Exception{
        if(book.getPath()!=null){
            System.out.println("path不为空");
            File file1=new File(book.getPath());
            file1.delete();
        }
        ImgUploadUtil imgUploadUtil=new ImgUploadUtil();
        String filename=null;
        if (file.isEmpty()) {
            System.out.println("文件为空");
        }
        String path="/www/wwwroot/yanglq.xyz/images/userImg/book/";
        String picUrl="/img/userImg/book/";
//        String path="e:/yfn/diary/";
//        String picUrl="/img/diary/";
        filename=imgUploadUtil.imgUpload(file,path);
        if (filename==null){
            return -1;
        }
        book.setHeadUrl(picUrl+filename);
        book.setPath(path+filename);
        return diaryService.updateBook(book);
    }

    @ResponseBody
    @RequestMapping("/deleteBook")
    public int deleteBook(int id)throws Exception{
        List<Diary> list=diaryService.listDiary(id);
        for(Diary diary:list){
           deleteDiary(diary.getId());
        }
        Book book=diaryService.queryBookById(id);
        File file=new File(book.getPath());
        file.delete();
        return diaryService.deleteBook(id);
    }

    @ResponseBody
    @RequestMapping("/deleteDiary")
    public int deleteDiary(int id)throws Exception{
        List<Img> list=diaryService.listImg(id);
        for(Img img:list){
            File file=new File(img.getPath());
            System.out.println(img.getPath());
            file.delete();
            diaryService.deleteImg(img.getId());
        }
        return diaryService.deleteDiary(id);
    }
    @ResponseBody
    @RequestMapping(value ="/updateDiary",method = RequestMethod.POST)
    public int updateDiary(@RequestParam(value = "file")MultipartFile file,int id)throws Exception{
        ImgUploadUtil imgUploadUtil=new ImgUploadUtil();
        String filename=null;
        if (file.isEmpty()) {
            System.out.println("文件为空");
        }
        String path="/www/wwwroot/yanglq.xyz/images/userImg/diary/";
        String picUrl="/img/userImg/diary/";
//        String path="e:/yfn/diary/";
//        String picUrl="/img/diary/";
        filename=imgUploadUtil.imgUpload(file,path);
        if (filename==null){
            return -1;
        }
        picUrl=picUrl+filename;
        path=path+filename;
        Img img=new Img(id,picUrl,path);
        return diaryService.addImg(img);
    }


    @ResponseBody
    @RequestMapping(value = "/addDiary")
    public int addDiary(Diary diary)throws Exception{
        Date date=new Date();
        diary.setDate(date);
        diaryService.addDiary(diary);
        return diary.getId();
    }

    public static int exchange(String s){
        int foo;
        try {
            foo = Integer.parseInt(s);
        }
        catch (NumberFormatException e)
        {
            foo = 0;
        }

        return foo;
    }

    public static String intExchange(int i){
        String str=String.format("%02d",i);
        return str;
    }


}

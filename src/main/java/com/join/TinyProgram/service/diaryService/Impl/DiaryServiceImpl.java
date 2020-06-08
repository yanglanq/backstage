package com.join.TinyProgram.service.diaryService.Impl;

import com.join.TinyProgram.entity.book.Book;
import com.join.TinyProgram.entity.diary.Diary;
import com.join.TinyProgram.entity.img.Img;
import com.join.TinyProgram.mapper.book.BookMapper;
import com.join.TinyProgram.mapper.diary.DiaryMapper;
import com.join.TinyProgram.service.diaryService.DiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Author: Yangfn
 * @Description:
 * @Date: 0:03 2020/6/3
 */
@Service
public class DiaryServiceImpl implements DiaryService {
    @Autowired
    DiaryMapper diaryMapper;

    @Autowired
    BookMapper bookMapper;

    @Override
    public List<Diary> listDiary(int userId)throws Exception{
        return diaryMapper.listDiary(userId);
    }

    @Override
    public int addDiary(Diary diary)throws Exception{
        return diaryMapper.addDiary(diary);
    }

    @Override
    public int deleteDiary(int id)throws Exception{
        return diaryMapper.deleteDiary(id);
    }
    @Override
    public int updateDiary(Diary diary)throws Exception{
        return diaryMapper.updateDiary(diary);
    }

    @Override
    public List<Book> listBook(int uid)throws Exception{
        return bookMapper.listBook(uid);
    }
    @Override
    public int addBook(Book book)throws Exception{
        bookMapper.addBook(book);
        return book.getId();
    }
    @Override
    public int updateBook(Book book)throws Exception{
        return bookMapper.updateBook(book);
    }
    @Override
    public int deleteBook(int id)throws Exception{
        return bookMapper.deleteBook(id);
    }
    @Override
    public int addImg(Img img)throws Exception{
        return diaryMapper.addImg(img);
    }

    @Override
    public int deleteImg(int id)throws Exception{
        return diaryMapper.deleteImg(id);
    }
    @Override
    public List<Img> listImg(int did)throws Exception{
        return diaryMapper.listImg(did);
    }
    @Override
    public int freshBook(int id)throws Exception{
        Date date=new Date();
        return bookMapper.freshBook(id,date);
    }


}

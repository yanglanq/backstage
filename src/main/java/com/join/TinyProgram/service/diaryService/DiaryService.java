package com.join.TinyProgram.service.diaryService;

import com.join.TinyProgram.entity.book.Book;
import com.join.TinyProgram.entity.diary.Diary;
import com.join.TinyProgram.entity.img.Img;

import java.util.List;

/**
 * @Author: Yangfn
 * @Description:
 * @Date: 0:03 2020/6/3
 */
public interface DiaryService {
    public List<Diary> listDiary(int bid)throws Exception;

    public int addDiary(Diary diary)throws Exception;

    public int updateDiary(Diary diary)throws Exception;

    public int deleteDiary(int id)throws Exception;

    public List<Book> listBook(int uid)throws Exception;

    public Book queryBookById(int id)throws Exception;

    public Diary queryDiaryById(int id)throws Exception;

    public int update(Book book)throws Exception;

    public int addBook(Book book)throws Exception;

    public int addImg(Img img)throws Exception;

    public int updateBook(Book book)throws Exception;

    public int deleteBook(int id)throws Exception;

    public int deleteImg(int id)throws Exception;

    public int freshBook(int id)throws Exception;

    public List<Img> listImg(int did)throws Exception;
}

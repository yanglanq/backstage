package com.join.TinyProgram.service.diaryService;

import com.join.TinyProgram.entity.diary.Diary;

import java.util.List;

/**
 * @Author: Yangfn
 * @Description:
 * @Date: 0:03 2020/6/3
 */
public interface DiaryService {
    public List<Diary> listDiary(int userId)throws Exception;

    public int addDiary(Diary diary)throws Exception;

    public int updateDiary(Diary diary)throws Exception;

    public int deleteDiary(int id)throws Exception;
}

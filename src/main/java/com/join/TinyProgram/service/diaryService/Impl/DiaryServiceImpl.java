package com.join.TinyProgram.service.diaryService.Impl;

import com.join.TinyProgram.entity.diary.Diary;
import com.join.TinyProgram.mapper.diary.DiaryMapper;
import com.join.TinyProgram.service.diaryService.DiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public List<Diary> listDiary(int userId)throws Exception{
        return diaryMapper.listDiary(userId);
    }

    @Override
    public int addDiary(Diary diary)throws Exception{
        return diaryMapper.addDiary(diary);
        //return userMapper.updateDiary(diary);
    }

    @Override
    public int deleteDiary(int id)throws Exception{
        return diaryMapper.deleteDiary(id);
    }
    @Override
    public int updateDiary(Diary diary)throws Exception{
        return diaryMapper.updateDiary(diary);
    }


}

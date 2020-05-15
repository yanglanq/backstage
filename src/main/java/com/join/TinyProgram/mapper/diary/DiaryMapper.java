package com.join.TinyProgram.mapper.diary;
import com.join.TinyProgram.entity.diary.Diary;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * @Author: Yangfn
 * @Description:
 * @Date: 19:51 2020/5/14
 */

@Repository
@Mapper
public interface DiaryMapper {

    /**
     * 增加日记
     * @param
     * @return
     * @throws Exception
     */
    public int addDiary(@Param("diary")Diary diary)throws Exception;

    /**
     * 删除日记
     * @param
     * @return
     * @throws Exception
     */
    public int deleteDiary(@Param("id")int id)throws Exception;
    /**
     * 修改日记
     * @param
     * @return
     * @throws Exception
     */
    public int updateDiary(@Param("diary")Diary diary)throws Exception;

    /**
     * 删除日记
     * @param
     * @return
     * @throws Exception
     */
    public List<Diary> listDiary(@Param("userId")int userId)throws Exception;
}

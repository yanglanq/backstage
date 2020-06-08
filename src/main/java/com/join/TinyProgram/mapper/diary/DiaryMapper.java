package com.join.TinyProgram.mapper.diary;
import com.join.TinyProgram.entity.diary.Diary;
import com.join.TinyProgram.entity.img.Img;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
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
    public int addDiary(Diary diary)throws Exception;

    /**
     * 增加日记
     * @param
     * @return
     * @throws Exception
     */
    public int addImg(@Param("img")Img img)throws Exception;

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
     *
     * @param
     * @return
     * @throws Exception
     */
    public List<Diary> listDiary(@Param("bid")int bid)throws Exception;

    /**
     * 删除日记
     * @param
     * @return
     * @throws Exception
     */
    public Diary queryDiaryById(@Param("id")int id)throws Exception;

    /**
     *
     * @param
     * @return
     * @throws Exception
     */
    public List<Img> listImg(@Param("did")int did)throws Exception;
    /**
     * 删除
     * @param
     * @return
     * @throws Exception
     */
    public int deleteImg(@Param("id")int id)throws Exception;
}

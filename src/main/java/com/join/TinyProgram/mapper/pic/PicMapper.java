package com.join.TinyProgram.mapper.pic;

import com.join.TinyProgram.entity.pic.Pic;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * author dongml
 * time 4/6/2020
 * description
 */
@Mapper
public interface PicMapper {
    List<Pic> getAll();
    boolean delete(Integer id);
    boolean update(String url,Integer id,String intro,Integer num);
    boolean addNew(String url,String intro,Integer num);
    boolean add(Integer num);
    boolean minus(Integer num);
    Integer getIdPre();
}

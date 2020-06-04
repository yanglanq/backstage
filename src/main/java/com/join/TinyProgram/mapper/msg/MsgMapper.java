package com.join.TinyProgram.mapper.msg;

import com.join.TinyProgram.entity.msg.Msg;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * author dongml
 * time 3/6/2020
 * description
 */
@Mapper
public interface MsgMapper {
    List<Msg> getAll();
    boolean update(@Param("msg")String msg,@Param("id")Integer id);
    boolean delete(@Param("id")Integer id);
    boolean addNew(@Param("msg")String msg);
}

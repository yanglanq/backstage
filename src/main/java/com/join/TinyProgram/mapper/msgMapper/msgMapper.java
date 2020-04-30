package com.join.TinyProgram.mapper.msgMapper;

import com.join.TinyProgram.entity.Msg;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * author dongml
 * time 29/4/2020
 * description
 */
@Mapper
public interface msgMapper {

    List<Msg> getAll();
}

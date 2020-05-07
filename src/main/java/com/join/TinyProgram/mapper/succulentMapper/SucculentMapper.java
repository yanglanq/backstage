package com.join.TinyProgram.mapper.succulentMapper;

import com.join.TinyProgram.entity.Succulent;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * author dongml
 * time 6/5/2020
 * description
 */
@Mapper
public interface SucculentMapper {
    boolean addNew(Succulent succulent);
    List<Succulent> getAll() throws Exception;
    List<Succulent> getSucculentByPage(Integer pageNum,Integer size);
    List<Succulent> searchByword(Succulent succulent);
}

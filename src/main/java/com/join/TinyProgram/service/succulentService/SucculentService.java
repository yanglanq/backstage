package com.join.TinyProgram.service.succulentService;

import com.github.pagehelper.PageInfo;
import com.join.TinyProgram.entity.Succulent;

import java.util.List;

/**
 * author dongml
 * time 6/5/2020
 * description
 */
public interface SucculentService {

    boolean addNew(Succulent succulent) throws Exception;
    List<Succulent> getAll() throws Exception;
    PageInfo<Succulent> getSucculentByPage(Integer pageNum, Integer size) throws Exception;
}

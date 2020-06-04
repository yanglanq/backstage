package com.join.TinyProgram.service.succulentService.impl;

//import com.github.pagehelper.PageHelper;
//import com.github.pagehelper.PageInfo;
import com.join.TinyProgram.entity.succulent.Succulent;
import com.join.TinyProgram.mapper.succulentMapper.SucculentMapper;
import com.join.TinyProgram.service.succulentService.SucculentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author dongml
 * time 6/5/2020
 * description
 */
@Service
public class SucculentServiceImpl implements SucculentService {
    @Autowired
    SucculentMapper succulentMapper;

    @Override
    public boolean addNew(Succulent succulent) throws NullPointerException{
        if(succulent == null){
            throw new NullPointerException();
        }
        return succulentMapper.addNew(succulent);
    }

    @Override
    public List<Succulent> getAll() throws Exception{
        return succulentMapper.getAll();
    }

//    @Override
//    public PageInfo<Succulent> getSucculentByPage(Integer pageNum,Integer size) throws Exception{
//        PageHelper.startPage(pageNum,size);
//        List<Succulent> list = succulentMapper.getAll();
//        PageInfo<Succulent> pageInfo = new PageInfo<>(list);
//        return pageInfo;
//    }

    @Override
    public List<Succulent> searchByword(String word){
        List<Succulent> list = succulentMapper.searchByword(word);
        if(list.size() != 0){
            succulentMapper.addSearch(word);
        }
        return list;
    }

    @Override
    public boolean delete(Integer id){
        return succulentMapper.delete(id);
    }

    @Override
    public boolean update(Succulent succulent){
        return succulentMapper.update(succulent);
    }

    @Override
    public boolean addSearch(String word){
        return succulentMapper.addSearch(word);
    }

    @Override
    public List<String> getHotWord(){
        return succulentMapper.getHotWord();
    }
}

package com.join.TinyProgram.service.picService.impl;

import com.join.TinyProgram.entity.pic.Pic;
import com.join.TinyProgram.mapper.pic.PicMapper;
import com.join.TinyProgram.service.picService.PicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author dongml
 * time 4/6/2020
 * description
 */
@Service
public class PicServiceImpl implements PicService {

    @Autowired
    PicMapper picMapper;

    @Override
    public List<Pic> getAll(){
        return picMapper.getAll();
    }

    @Override
    public boolean delete(Integer id,Integer num){
        boolean b = picMapper.delete(id);
        picMapper.minus(num);
        return b;
    }

    @Override
    public boolean update(String url,Integer id,String intro,Integer num){
        return picMapper.update(url,id,intro,num);
    }

    @Override
    public boolean addNew(String url,String intro,Integer num){
        picMapper.add(num);
        return picMapper.addNew(url, intro,num);
    }

    @Override
    public Integer getIdPre(){
        return picMapper.getIdPre();
    }
}

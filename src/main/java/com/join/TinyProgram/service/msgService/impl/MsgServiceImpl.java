package com.join.TinyProgram.service.msgService.impl;

import com.join.TinyProgram.entity.msg.Msg;
import com.join.TinyProgram.mapper.msg.MsgMapper;
import com.join.TinyProgram.service.msgService.MsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author dongml
 * time 29/4/2020
 * description
 */
@Service
public class MsgServiceImpl implements MsgService {
    @Autowired
    MsgMapper msgMapper;

    @Override
    public List<Msg> getAll() {
        return msgMapper.getAll();
    }

    @Override
    public boolean update(String msg,Integer id){
        return msgMapper.update(msg, id);
    }

    @Override
    public boolean delete(Integer id){
        return msgMapper.delete(id);
    }

    @Override
    public boolean addNew(String msg){
        return msgMapper.addNew(msg);
    }
}

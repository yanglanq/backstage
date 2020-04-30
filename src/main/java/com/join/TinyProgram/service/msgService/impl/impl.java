package com.join.TinyProgram.service.msgService.impl;

import com.join.TinyProgram.entity.Msg;
import com.join.TinyProgram.mapper.msgMapper.msgMapper;
import com.join.TinyProgram.service.msgService.msgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * author dongml
 * time 29/4/2020
 * description
 */
@Service
public class impl implements msgService {
    @Autowired
    msgMapper msgMapper;

    @Override
    public List<Msg> getAll() {
        return msgMapper.getAll();
    }
}

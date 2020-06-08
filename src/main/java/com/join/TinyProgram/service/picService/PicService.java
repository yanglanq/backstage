package com.join.TinyProgram.service.picService;

import com.join.TinyProgram.entity.msg.Msg;
import com.join.TinyProgram.entity.pic.Pic;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author dongml
 * time 4/6/2020
 * description
 */
public interface PicService {

    List<Pic> getAll();
    boolean delete(Integer id,Integer num);
    boolean update(String url,Integer id,String intro,Integer num);
    boolean addNew(String url,String intro,Integer num);
    Integer getIdPre();
    Msg getByRand();
}

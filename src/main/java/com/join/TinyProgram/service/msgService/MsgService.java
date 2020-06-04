package com.join.TinyProgram.service.msgService;

import com.join.TinyProgram.entity.msg.Msg;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * author dongml
 * time 3/6/2020
 * description
 */
public interface MsgService {
    List<Msg> getAll();
    boolean update(String msg,Integer id);
    boolean delete(Integer id);
    boolean addNew(String msg);
}

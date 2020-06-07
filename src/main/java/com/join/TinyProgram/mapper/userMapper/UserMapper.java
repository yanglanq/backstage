package com.join.TinyProgram.mapper.userMapper;

import com.join.TinyProgram.entity.diary.Diary;
import com.join.TinyProgram.entity.user.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: Yangfn
 * @Description:
 * @Date: 22:19 2020/5/9
 */
@Repository
@Mapper
public interface UserMapper {
    /**
     * 登录
     * @param user
     * @return
     * @throws Exception
     */
    public int updateUser(@Param("user")User user) throws Exception;

    /**
     * 注册
     * @param user
     * @return
     * @throws Exception
     */
    public int addUser(User user)throws Exception;

    /**
     * 删除
     * @param
     * @return
     * @throws Exception
     */
    public int deleteUser(@Param("id")int id)throws Exception;

    /**
     * 列出所有user
     * @return
     * @throws Exception
     */
    public List<User> listUser()throws Exception;
    /**
     * 查询
     * @return
     * @throws Exception
     */
    public User queryUser(@Param("openid")String openid)throws Exception;

}

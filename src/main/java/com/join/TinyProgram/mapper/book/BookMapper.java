package com.join.TinyProgram.mapper.book;

import com.join.TinyProgram.entity.book.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: Yangfn
 * @Description:
 * @Date: 0:18 2020/6/3
 */
@Repository
@Mapper
public interface BookMapper {
    /**
     * 增加日记
     * @param
     * @return
     * @throws Exception
     */
    public int addBook(@Param("book")Book book)throws Exception;

    /**
     * 删除日记
     * @param
     * @return
     * @throws Exception
     */
    public int deleteBook(@Param("id")int id)throws Exception;
    /**
     * 修改日记
     * @param
     * @return
     * @throws Exception
     */
    public int updateBook(@Param("book")Book book)throws Exception;

    /**
     * 删除日记
     * @param
     * @return
     * @throws Exception
     */
    public List<Book> listBook(@Param("uid")int uid)throws Exception;
}

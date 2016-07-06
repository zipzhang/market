package com.seasun.mybatis.mapper.qa;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.seasun.mybatis.model.Book;

public interface BookMapper {
    
    @Select("select * from book")
    List<Book> queryAllBooks();
}

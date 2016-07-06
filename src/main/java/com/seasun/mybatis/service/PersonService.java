package com.seasun.mybatis.service;

import java.util.List;

import com.seasun.mybatis.mapper.qa.BookMapper;
import com.seasun.mybatis.model.Book;
import com.seasun.mybatis.model.Person;

public interface PersonService {
    
    public List<Person> queryAllPerson();
    
    public List<Book> queryAllBooks();
}

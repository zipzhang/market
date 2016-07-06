package com.seasun.mybatis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Service;

import com.seasun.mybatis.mapper.mime.PersonMapper;
import com.seasun.mybatis.mapper.qa.BookMapper;
import com.seasun.mybatis.model.Book;
import com.seasun.mybatis.model.Person;
@Service
public class PersonServiceImpl implements PersonService{
    @Autowired
    private PersonMapper personMapper;
    
    @Autowired
    private BookMapper bookMapper;
    
    @Override
    public List<Person> queryAllPerson() {
        return personMapper.findAllPerson();
    }

    @Override
    public List<Book> queryAllBooks() {       
        return bookMapper.queryAllBooks();
    }
    
    
}

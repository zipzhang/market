package com.seasun.mybatis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seasun.mybatis.config.LiHao;
import com.seasun.mybatis.model.Book;
import com.seasun.mybatis.service.PersonService;

@RestController
public class BookController {
    
    @Autowired
    private PersonService personService;
    
    @Autowired
    private LiHao lihao;
    
    @RequestMapping(value = "/query-all-books")
    public ResponseEntity<?> queryAllPerson() {
        List<Book> persons = personService.queryAllBooks();
        return ResponseEntity.ok(persons);   
    }
    
    @RequestMapping(value = "/query-lihao")
    public ResponseEntity<?> queryLiHao() {
        System.out.println(lihao.getHabits());
        System.out.println(lihao.getHeight());
        System.out.println(lihao.getLove());
        System.out.println(lihao.getName());
        
        return ResponseEntity.ok().build();   
    }
}

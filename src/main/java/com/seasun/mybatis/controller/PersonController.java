package com.seasun.mybatis.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seasun.mybatis.model.Person;
import com.seasun.mybatis.service.PersonService;

@RestController
public class PersonController {
    @Autowired
    private PersonService personService;
    
    private static final Logger LOGGER = LoggerFactory.getLogger(PersonController.class);
    
    @RequestMapping(value = "/query-all-person")
    public ResponseEntity<?> queryAllPerson() {
        try {
            LOGGER.info("begin PersonController query-all-person....");
            List<Person> persons = personService.queryAllPerson();
            LOGGER.info("end PersonController query-all-person....");
            return ResponseEntity.ok(persons);
        } catch (Throwable t) {
            LOGGER.error("system exception", t);
            return ResponseEntity.badRequest().build();
        }
    }
}

package com.seasun.mybatis.mapper.mime;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.seasun.mybatis.model.Person;

public interface PersonMapper {
    @Select("select * from person")
    List<Person> findAllPerson();
}

package com.seasun.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@MapperScan("com.seasun.mybatis.mapper")
public class MybatisInitDemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(MybatisInitDemoApplication.class, args);
	}
}

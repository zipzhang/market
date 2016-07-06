package com.seasun.mybatis.config;


import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@MapperScan(basePackages = "com.seasun.mybatis.mapper.mime", sqlSessionFactoryRef = "mimeSqlSessionFactory")
public class MimeDataSourceConfig {
   
    @Bean(name = "mimeDatasource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource mimeSourceConfig() {        
        return DataSourceBuilder.create().build();
    }
        
    @Bean(name = "mimeSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactoryBean() throws Throwable {
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(mimeSourceConfig());
        SqlSessionFactory sqlSessionFactory = sessionFactoryBean.getObject();
        sqlSessionFactory.getConfiguration().setMapUnderscoreToCamelCase(true);
        sqlSessionFactory.getConfiguration().getTypeAliasRegistry().registerAliases("com.seasun.mybatis.model");    
        
        return sessionFactoryBean.getObject();
    }    
}

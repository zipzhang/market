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

@Configuration
@MapperScan(basePackages = "com.seasun.mybatis.mapper.qa", sqlSessionFactoryRef = "qaSqlSessionFactory")
public class QaDatasourceConfig {
  
    @Bean(name = "qaDatasource")
    @ConfigurationProperties(prefix = "spring.datasource.qa")
    public DataSource qaSourceConfig() {
        return DataSourceBuilder.create().build();
    }
    
    @Bean(name = "qaSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactoryBean() throws Throwable {
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(qaSourceConfig());
        SqlSessionFactory sqlSessionFactory = sessionFactoryBean.getObject();
        sqlSessionFactory.getConfiguration().setMapUnderscoreToCamelCase(true);
        sqlSessionFactory.getConfiguration().getTypeAliasRegistry().registerAliases("com.seasun.mybatis.model");    
        
        return sessionFactoryBean.getObject();
    }
}

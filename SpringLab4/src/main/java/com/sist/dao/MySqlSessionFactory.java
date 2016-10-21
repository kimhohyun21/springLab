package com.sist.dao;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("ssf")
public class MySqlSessionFactory extends SqlSessionFactoryBean{
	@Autowired
	public void initDao(DataSource ds){
		setDataSource(ds); //µî·ÏÇØµÐ DB Á¤º¸¸¦ °¡Á®¿È.
	}

}

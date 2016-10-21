package com.sist.dao;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("mapper")
public class MyMapperBeanFactory extends MapperFactoryBean {
	@Autowired
	public void initDao(SqlSessionFactory ssf){
		setSqlSessionFactory(ssf); //실행이 되면 session 생성 ==> DB에 연결
	}
	
	public MyMapperBeanFactory(){
		setMapperInterface(EmpMapper.class); //sql문 실행
	}
}

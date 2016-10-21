package com.sist.dao;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("mapper")
public class MyMapperBeanFactory extends MapperFactoryBean {
	@Autowired
	public void initDao(SqlSessionFactory ssf){
		setSqlSessionFactory(ssf); //������ �Ǹ� session ���� ==> DB�� ����
	}
	
	public MyMapperBeanFactory(){
		setMapperInterface(EmpMapper.class); //sql�� ����
	}
}

package com.sist.dao3;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/*
	<bean id="sqlSessionTemplete" class="org.mybatis.spring.SqlSessionTemplate">
		<constructor-arg ref="ssf"/>
	</bean>
*/
@Component("sqlTemplete")
public class MyOracleSqlTemplete extends SqlSessionTemplate{

	@Autowired //생성자에는 Resource가 안됨
	public MyOracleSqlTemplete(SqlSessionFactory sqlSessionFactory) {
		super(sqlSessionFactory);
	}

}

package com.sist.dao;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.stereotype.Component;

@Component("ds") //어노테이션할 때, 이름을 정하면 다른 곳에서도 사용 가능
public class MyBasicDataSource extends BasicDataSource{
	public MyBasicDataSource(){
		//MyBasicDataSource를 생성자로 만들어서 DB생성 정보를 설정하고 beans으로 등록하면, 
		//호출될때 DB 연결정보를 넘겨주게 됨
		//값 적용할 때, this 생략도 가능함
		this.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		this.setUrl("jdbc:oracle:thin:@211.238.142.88:1521:ORCL"); 
		setUsername("scott");
		setPassword("tiger");
		
	}
}

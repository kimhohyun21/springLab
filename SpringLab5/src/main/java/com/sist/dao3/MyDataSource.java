package com.sist.dao3;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.stereotype.Component;
/*
	
	<bean id="ds" class="org.apache.commons.dbcp.BasicDataSource"
		p:driverClassName="#{db['driver'] }"
		p:url="#{db['url']}"
		p:username="#{db['username']}"
		p:password="#{db['password']}"
	/>

 */
@Component("ds")
public class MyDataSource extends BasicDataSource{
	public MyDataSource(){
		this.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		this.setUrl("jdbc:oracle:thin:@211.238.142.88:1521:ORCL");
		this.setUsername("scott");
		this.setPassword("tiger");
	}
}

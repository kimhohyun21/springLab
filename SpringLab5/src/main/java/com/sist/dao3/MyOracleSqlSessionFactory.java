package com.sist.dao3;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

/*

  <bean id="ssf" class="org.mybatis.spring.SqlSessionFactoryBean"
	p:dataSource-ref="ds"
	p:configLocation="classpath:config.xml"
  />
 
 */
@Component("ssf")
public class MyOracleSqlSessionFactory extends SqlSessionFactoryBean{
	//p:dataSource-ref="ds"
	@Resource(name="ds") //ds이름을 찾아서 ds를 주입해주고 컨테이너에 객체 생성 
	public void initDao(DataSource datasource){
		setDataSource(datasource);
	}
	
	//p:configLocation="classpath:config.xml"
	public MyOracleSqlSessionFactory(){
		try{
			org.springframework.core.io.Resource res=new ClassPathResource("config.xml");
			setConfigLocation(res);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}

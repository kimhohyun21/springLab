package com.sist.dao;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.stereotype.Component;

@Component("ds") //������̼��� ��, �̸��� ���ϸ� �ٸ� �������� ��� ����
public class MyBasicDataSource extends BasicDataSource{
	public MyBasicDataSource(){
		//MyBasicDataSource�� �����ڷ� ���� DB���� ������ �����ϰ� beans���� ����ϸ�, 
		//ȣ��ɶ� DB ���������� �Ѱ��ְ� ��
		//�� ������ ��, this ������ ������
		this.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		this.setUrl("jdbc:oracle:thin:@211.238.142.88:1521:ORCL"); 
		setUsername("scott");
		setPassword("tiger");
		
	}
}

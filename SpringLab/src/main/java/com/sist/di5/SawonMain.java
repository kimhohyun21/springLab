package com.sist.di5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SawonMain {

	public static void main(String[] args) {
		ApplicationContext app=new ClassPathXmlApplicationContext("com/sist/di5/app.xml");
		//==> new Sawon(), new SawonConfig()�� ���� ��ü �������� ����
		
		SawonConfig sc=(SawonConfig) app.getBean("sc");
		sc.print();
	}

}

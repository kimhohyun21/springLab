package com.sist.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		ApplicationContext app=new ClassPathXmlApplicationContext("classpath:app.xml");
		
		SawonConfig sc=(SawonConfig) app.getBean("sc");
		sc.print();
	}
}

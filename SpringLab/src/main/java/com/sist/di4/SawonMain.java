package com.sist.di4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SawonMain {
	public static void main(String[] args){
		ApplicationContext app=new ClassPathXmlApplicationContext("com/sist/di4/app.xml");
		
		Sawon sawon=(Sawon) app.getBean("sal"); //DL ==> com.sist.di4.Sawon 생성, DI ==> setter 작동
		sawon.print();
		Sawon sawon2=(Sawon) app.getBean("sal2");
		sawon2.print();
		
	}
}

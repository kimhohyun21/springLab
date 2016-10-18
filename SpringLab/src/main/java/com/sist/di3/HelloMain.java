package com.sist.di3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloMain {
	public static void main(String[] args){
		ApplicationContext app=new ClassPathXmlApplicationContext("com/sist/di3/app.xml");
		
		Hello h=(Hello) app.getBean("hello"); //==> xml���� ������ bean�� id�� ����
		System.out.println("h : "+h);
		String result=h.sayHello("��ȣ��");
		System.out.println(result);
		
		h=(Hello) app.getBean("hello");
		System.out.println("h2 : "+h);
	}
}

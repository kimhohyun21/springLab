package com.sist.di3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloMain {
	public static void main(String[] args){
		ApplicationContext app=new ClassPathXmlApplicationContext("com/sist/di3/app.xml");
		
		Hello h=(Hello) app.getBean("hello"); //==> xml에서 정의한 bean의 id값 적용
		System.out.println("h : "+h);
		String result=h.sayHello("김호현");
		System.out.println(result);
		
		h=(Hello) app.getBean("hello");
		System.out.println("h2 : "+h);
	}
}

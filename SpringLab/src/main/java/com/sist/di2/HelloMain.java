package com.sist.di2;

public class HelloMain {
	public static void main(String[] args){
		Hello h=new HelloImpl();
		String result=h.sayHello("���缮");
		System.out.println(result);	
	}
}

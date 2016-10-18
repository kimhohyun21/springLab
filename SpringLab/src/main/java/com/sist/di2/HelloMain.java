package com.sist.di2;

public class HelloMain {
	public static void main(String[] args){
		Hello h=new HelloImpl();
		String result=h.sayHello("À¯Àç¼®");
		System.out.println(result);	
	}
}

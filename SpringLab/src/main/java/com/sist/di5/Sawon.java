package com.sist.di5;

public class Sawon {
	private int sabun;
	private String name;
	private String dept;
	
	public Sawon(int sabun, String name, String dept) {
		super();
		this.sabun = sabun;
		this.name = name;
		this.dept = dept;
		System.out.println("Sawon 객체 생성");
	}
	
	public void print(){
		System.out.println("사번 : "+sabun);
		System.out.println("이름 : "+name);
		System.out.println("부서 : "+dept);
	}	
}

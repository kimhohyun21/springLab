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
		System.out.println("Sawon ��ü ����");
	}
	
	public void print(){
		System.out.println("��� : "+sabun);
		System.out.println("�̸� : "+name);
		System.out.println("�μ� : "+dept);
	}	
}

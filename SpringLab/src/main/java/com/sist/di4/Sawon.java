package com.sist.di4;

public class Sawon {
	private int sabun;
	private String name;
	private String dept;
	
	public int getSabun() {
		return sabun;
	}
	public void setSabun(int sabun) {
		this.sabun = sabun;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	
	public void init(){
		System.out.println("************�������*************");
	}
	
	public void print(){
		System.out.println("��� : "+sabun);
		System.out.println("�̸� : "+name);		
		System.out.println("�μ� : "+dept);
	}
}

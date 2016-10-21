package com.sist.di;

import java.util.*;

public class SawonConfig {
	private List<Sawon> list=new ArrayList<>();
	private Map map=new HashMap();
	
	public void setList(List<Sawon> list) {
		this.list = list;
	}
	public void setMap(Map map) {
		this.map = map;
	}
	
	public void print(){
		for(Sawon sa: list){
			System.out.println("��� : "+sa.getSabun());
			System.out.println("�̸� : "+sa.getName());
			System.out.println("�μ� : "+sa.getDept());
			System.out.println();
		}
	}
}

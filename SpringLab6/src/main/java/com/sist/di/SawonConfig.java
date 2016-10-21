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
			System.out.println("사번 : "+sa.getSabun());
			System.out.println("이름 : "+sa.getName());
			System.out.println("부서 : "+sa.getDept());
			System.out.println();
		}
	}
}

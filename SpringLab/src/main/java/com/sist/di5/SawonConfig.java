package com.sist.di5;

public class SawonConfig {
	private Sawon sa;

	public SawonConfig(){
		System.out.println("SawonConfig °´Ã¼ »ý¼º");
	}
	
	public void setSa(Sawon sa) {
		this.sa = sa;
	}
	
	public void print(){
		sa.print();
	}
	
}

package com.sist.model;

import org.springframework.stereotype.Repository;

@Repository
public class MyDAO {
	public void getConnection(){
		System.out.println("DataBase Connection");
	}
	
	public void disConnection(){
		System.out.println("DataBase DisConnection");
	}
}

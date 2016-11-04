package com.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;

/*부가기능*/
public class DBConnection {
	private Connection dbCon;
	private String driver;
	private String url;
	private String username;
	private String password;
	
	public Connection getDbCon() {
		return dbCon;
	}
	public void setDbCon(Connection dbCon) {
		this.dbCon = dbCon;
	}
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void init(){
		try{
			Class.forName(driver);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public void getConnection(){
		try{
			dbCon=DriverManager.getConnection(url,username,password);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public void disConnection(){
		try{
			if(dbCon!=null) dbCon.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}

























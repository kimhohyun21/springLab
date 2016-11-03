package com.sist.dao;

import java.sql.*;

public class DBConnection {
	private Connection dbcon;
	private String driver;
	private String url;
	private String username;
	private String password;
	
	public Connection getDbcon() {
		return dbcon;
	}
	public void setDbcon(Connection dbcon) {
		this.dbcon = dbcon;
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
	
	public DBConnection(String driver){
		try{
			Class.forName(driver);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void getConnection(){
		try{
			dbcon=DriverManager.getConnection(url, username, password);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void disConnection(){
		try{
			if(dbcon!=null){
				dbcon.close();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}

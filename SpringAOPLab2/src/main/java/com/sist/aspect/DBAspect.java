package com.sist.aspect;

import org.aspectj.lang.JoinPoint;

import com.sist.dao.DBConnection;

public class DBAspect {
	private DBConnection dbcon;

	public DBConnection getDbcon() {
		return dbcon;
	}

	public void setDbcon(DBConnection dbcon) {
		this.dbcon = dbcon;
	}
	
	public void getConnection(JoinPoint jp){
		dbcon.getConnection();
	}
	
	public void disConnection(JoinPoint jp){
		dbcon.disConnection();
	}
}

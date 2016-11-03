package com.sist.aop;

public class Common {
	private MyDAO dao;

	public MyDAO getDao() {
		return dao;
	}

	public void setDao(MyDAO dao) {
		this.dao = dao;
	}
	
	public void getConnection(){
		dao.getConnection();
	}
	
	public void disConnection(){
		dao.disConnection();
	}
}

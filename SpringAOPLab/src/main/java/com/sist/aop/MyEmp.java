package com.sist.aop;

public class MyEmp {
	private MyDAO dao;

	public MyDAO getDao() {
		return dao;
	}

	public void setDao(MyDAO dao) {
		this.dao = dao;
	}
	
	public void dbConnection(){
		dao.ainsert();
		dao.aselect("SELECT * FROM emp");
		dao.aupdate();
		dao.adelete();
	}
}

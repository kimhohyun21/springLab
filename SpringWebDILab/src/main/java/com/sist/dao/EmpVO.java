package com.sist.dao;

import java.util.*;

public class EmpVO {
	private int empno;
	private String ename;
	private String job;
	private Date hiredate;
	private int sal;
	
	//Join을 위한  has a 관계(포함 관계)
	private DeptVO dvo=new DeptVO();
	
	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public Date getHiredate() {
		return hiredate;
	}

	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}

	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}

	public DeptVO getDvo() {
		return dvo;
	}

	public void setDvo(DeptVO dvo) {
		this.dvo = dvo;
	}	
}

package com.sist.dao;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface EmpMapper {
	
	@Results({
		@Result(property="empno", column="empno"),
		//setEmpno(rs.getInt("empno"))와 같은 의미
		@Result(property="ename", column="ename"),
		@Result(property="job", column="job"),
		@Result(property="hiredate", column="hiredate"),
		@Result(property="sal", column="sal"),
		@Result(property="dvo.deptno", column="deptno"),
		@Result(property="dvo.dname", column="dname"),
		@Result(property="dvo.loc", column="loc")
	})
	@Select("SELECT empno, ename, job, hiredate, sal, deptno, dname, loc "
			+ "FROM emp NATURAL JOIN dept")
	public List<EmpVO> empdeptAllData();
	
	@Results({
		@Result(property="empno", column="empno"),
		@Result(property="ename", column="ename"),
		@Result(property="job", column="job"),
		@Result(property="hiredate", column="hiredate"),
		@Result(property="sal", column="sal"),
		@Result(property="dvo.deptno", column="deptno"),
		@Result(property="dvo.dname", column="dname"),
		@Result(property="dvo.loc", column="loc")
	})
	@Select("SELECT empno, ename, job, hiredate, sal, deptno, dname, loc "
			+ "FROM emp NATURAL JOIN dept WHERE empno=#{no}")
	public EmpVO empdeptFindData(int no);
}

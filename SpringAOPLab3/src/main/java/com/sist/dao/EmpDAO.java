package com.sist.dao;

import java.sql.*;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/*핵심기능*/
@Repository("dao")
public class EmpDAO {
	
	@Autowired
	private DBConnection dbcon;

	public DBConnection getDbcon() {
		return dbcon;
	}

	public void setDbcon(DBConnection dbcon) {
		this.dbcon = dbcon;
	}
	
	//기능추가
	private PreparedStatement ps;
	private ResultSet rs;
	
	public List<EmpVO> empAllData(){
		List<EmpVO> list=new ArrayList<EmpVO>();
		try{
			//getConnection(); ==> AOP 대체
			String sql="SELECT empno, ename, job, hiredate FROM emp";
			ps=dbcon.getDbCon().prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				EmpVO vo=new EmpVO();
				vo.setEmpno(rs.getInt(1));
				vo.setEname(rs.getString(2));
				vo.setJob(rs.getString(3));
				vo.setHiredate(rs.getDate(4));
				
				list.add(vo);
			}
			rs.close();
			ps.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			//disConnection(); ==> AOP 대체
		}
		
		return list;
	}
	
}

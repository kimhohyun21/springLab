package com.sist.dao;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/*
 * #DAO(Date Access Object) ����
 * 	: ������ �׼��� ������ DAO ������ ����
 * 		==> �����Ͻ� ������ ������ �׼��� ������ �и�
 * 		==> (���� ������ ������ ���� �����鼭)������ �׼��� ����� ���� ���� ����
 * 	
 * #DataSource : Ŀ�ؼ� Ǯ���� ����
 * 	: Ŀ�ؼ� Ǯ���� �̸� ������ ������ŭ�� DB Ŀ�ؼ��� Ǯ(pool)�� �غ��صΰ� 
 * 	    ���ø����̼��� ��û�� ��, �̸� ������� Ŀ�ؼ��� ������ �ϳ��� �Ҵ����ְ�
 * 	    ����Ŀ��� �ٽ� ���� �޾� pool�� �ִ� ���
 * 		==> ���� ����ڰ� �ִ� ������������ �ý����̶�� �ݵ�� DB Ŀ�ؼ� Ǯ�� ����� �����ϴ�
 * 			DataSource�� ����ؾ� ��
 * 		==> Spring������ DataSource�� ���� ������ Spring Bean���� ����ؼ� 
 * 			����� �� �ֵ��� ����	 
 * 
 * #JdbcTemplate Ŭ����
 *  : Spring JDBC�� �����ϴ� Ŭ���� �� JdbcTemplate�� JDBC�� ��� ����� �ִ��� Ȱ���ϴ� �������.
 *    	==> query() �޼ҵ�
 *       	: SELECT SQL�� �����Ͽ� �������� ROW�� ������.
 */
public class EmpDAO extends JdbcDaoSupport{
	public List<EmpVO> empAlldata(){
		
		String sql="SELECT empno, ename, job, hiredate, sal FROM emp";
		
		return getJdbcTemplate().query(sql, new RowMapper() {

			@Override
			public Object mapRow(ResultSet rs, int count) throws SQLException {
				
				EmpVO vo=new EmpVO();
				vo.setEmp(rs.getInt(1));
				vo.setEname(rs.getString(2));
				vo.setJob(rs.getString(3));
				vo.setHiredate(rs.getDate(4));
				vo.setSal(rs.getInt(5));
				
				return vo;
			}
		});
	}
}

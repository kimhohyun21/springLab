package com.sist.dao;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/*
 * #DAO(Date Access Object) 패턴
 * 	: 데이터 액세스 계층은 DAO 패턴을 적용
 * 		==> 비지니스 로직과 데이터 액세스 로직을 분리
 * 		==> (서비스 계층에 영향을 주지 않으면서)데이터 액세스 기술을 쉽게 변경 가능
 * 	
 * #DataSource : 커넥션 풀링을 지원
 * 	: 커넥션 풀링은 미리 정해진 개수만큼의 DB 커넥션을 풀(pool)에 준비해두고 
 * 	    어플리케이션이 요청할 때, 미리 만들어진 커넥션을 꺼내서 하나씩 할당해주고
 * 	    사용후에는 다시 돌려 받아 pool에 넣는 기법
 * 		==> 다중 사용자가 있는 엔터프라이즈 시스템이라면 반드시 DB 커넥션 풀링 기능을 지원하는
 * 			DataSource를 사용해야 함
 * 		==> Spring에서는 DataSource를 공유 가능한 Spring Bean으로 등록해서 
 * 			사용할 수 있도록 해줌	 
 * 
 * #JdbcTemplate 클래스
 *  : Spring JDBC가 제공하는 클래스 중 JdbcTemplate은 JDBC의 모든 기능을 최대한 활용하는 기능제공.
 *    	==> query() 메소드
 *       	: SELECT SQL을 실행하여 여러개의 ROW를 가져옴.
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

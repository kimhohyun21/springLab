package com.sist.dao2;

import java.util.*;

import org.mybatis.spring.support.SqlSessionDaoSupport;

public class EmpDAO extends SqlSessionDaoSupport{
	public List<EmpVO> empAllData(){
		
		return getSqlSession().selectList("empAllData");
	}
}

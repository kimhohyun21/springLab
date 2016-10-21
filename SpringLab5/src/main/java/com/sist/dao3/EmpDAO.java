package com.sist.dao3;

import java.util.*;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class EmpDAO extends SqlSessionDaoSupport{
	
	@Resource(name="sqlTemplete")
	public void initDAO(SqlSessionTemplate sst){
		setSqlSessionTemplate(sst);
	}
	
	public List<EmpVO> empAllData(){
		return getSqlSession().selectList("empAllData2");
	}
}

package com.sist.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmpDAO {
	@Autowired
	private EmpMapper mapper;	
	
	public List<EmpVO> empdeptAllData(){
		return mapper.empdeptAllData();
	}
	
	public EmpVO empdeptFindData(int no){
		return mapper.empdeptFindData(no);
	}
}

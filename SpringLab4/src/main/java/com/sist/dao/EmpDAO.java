package com.sist.dao;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmpDAO {
	@Autowired  //==> EmpMapper�� ����ϱ� ���� �ڵ����� �����̳ʿ� �����Ͽ� ����
	private EmpMapper empMapper;
	
	public List<EmpVO> empAllData(){
		return empMapper.empAllData();
	}
}

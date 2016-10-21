package com.sist.dao;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmpDAO {
	@Autowired  //==> EmpMapper를 사용하기 위해 자동으로 컨테이너에 주입하여 생성
	private EmpMapper empMapper;
	
	public List<EmpVO> empAllData(){
		return empMapper.empAllData();
	}
}

package com.sist.dao;

import java.util.*;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

public interface DataBoardMapper {
	
	@Select("SELECT no, subject, name, regdate, hit, num "
			+ "FROM (SELECT no, subject, name, regdate, hit, Rownum as num "
			+ "FROM (SELECT no, subject, name, regdate, hit "
			+ "FROM multiBoard ORDER BY no DESC)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<DataBoardVO> dataBoardListData(Map map);
	
	@Select("SELECT CEIL(COUNT(*)/10) FROM multiBoard")
	public int dataBoardTotalPage();
	
	@SelectKey(keyProperty="no", resultType=int.class, before=true,
			statement="SELECT NVL(MAX(no)+1, 1) as no FROM multiBoard")
	@Insert("INSERT INTO multiBoard VALUES(#{no}, #{name}, #{subject}, "
			+ "#{content}, #{pwd}, SYSDATE, 0, #{filename}, #{filesize}, #{filecount})")
	public void dataBoardInsert(DataBoardVO vo);
	
	@Update("UPDATE multiBoard SET hit=hit+1 WHERE no=#{no}")
	public void dataBoardHitIncrement(int no);
	
	@Select("SELECT no, name, subject, content, regdate, hit, filename, filesize, filecount FROM multiBoard WHERE no=#{no}")
	public DataBoardVO dataBoardContentData(int no);
}

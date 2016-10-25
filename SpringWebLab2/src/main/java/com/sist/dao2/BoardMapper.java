package com.sist.dao2;

import java.util.*;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

public interface BoardMapper {
	@Select("SELECT no, subject, name, regdate, hit, group_tab, num "
			+ "FROM (SELECT no, subject, name, regdate, hit, group_tab, rownum as num "
			+ "FROM (SELECT no, subject, name, regdate, hit, group_tab "
			+ "FROM replyBoard ORDER BY group_id DESC, group_setp ASC))" + "WHERE num BETWEEN #{start} AND #{end}")
	public List<BoardVO> boardListData(Map map); // interface ?Ñ†?ñ∏Î¨? ?òï?ãù

	@Select("SELECT CEIL(COUNT(*)/10) FROM replyBoard")
	public int boardTotalPage();

	@SelectKey(keyProperty = "no", before = true, resultType = int.class, statement = {
			"SELECT NVL(MAX(no)+1,1) as no FROM replyboard" }) // noÍ∞? Íµ¨ÌïòÍ∏?
	@Insert("INSERT INTO replyboard VALUES(" + "#{no},#{name},#{email},#{subject},#{content},#{pwd},SYSDATE,0,"
			+ "(SELECT NVL(MAX(group_id)+1,1) FROM replyboard)," + "0,0,0,0)")
	public void boardInsert(BoardVO vo);
}

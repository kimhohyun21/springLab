package com.sist.dao;

import java.util.*;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

public interface BoardMapper {
	@Select("SELECT no, name, subject, regdate, hit, group_tab, num "
			+ "FROM (SELECT no, name, subject, regdate, hit, group_tab, ROWNUM as num "
			+ "FROM (SELECT no, name, subject, regdate, hit, group_tab "
			+ "FROM replyBoard ORDER BY group_id DESC, group_step ASC))"
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<BoardVO> boardListData(Map map);
	
	@Select("SELECT CEIL(COUNT(*)/10) FROM board")
	public int boardTotalPage();
	
	@SelectKey(keyProperty="no", resultType=int.class, before=true, 
				statement="SELECT NVL(MAX(no)+1, 1) as no FROM replyBoard")
	@Insert("INSERT INTO replyBoard (no, name, email, subject, content, pwd, group_id) "
			+ "VALUES(#{no}, #{name}, #{email}, #{subject}, #{content}, #{pwd},"
			+ "(SELECT NVL(MAX(group_id)+1, 1) as group_id FROM replyBoard))")
	public void boardInsert(BoardVO vo);
	
	@Update("UPDATE replyBoard SET hit=hit+1 WHERE no=#{no}")
	public void boardHitIncrement(String no);
	
	@Select("SELECT no, name, subject, content, regdate, hit FROM replyBoard WHERE no=#{no}")
	public BoardVO boardContentData(String no);
	
	@Select("SELECT no, email, name, subject, content FROM replyBoard WHERE no=#{no}")
	public BoardVO boardUpdate(int no);
	
	@Select("SELECT pwd FROM replyBoard WHERE no=#{no}")
	public String boardGetPwd(int no);
	
	@Update("UPDATE replyBoard SET name=#{name}, email=#{email}, subject=#{subject}, content=#{content} WHERE no=#{no}")
	public void boardUpdateData(BoardVO vo);
	
	@Select("SELECT group_id, group_step, group_tab FROM replyBoard WHERE no=#{no}")
	public BoardVO boardParentData(String no);
	
	@Update("UPDATE replyBoard SET group_step=group_step+1, group_tab=group_tab+1 "
			+ "WHERE group_id=#{group_id} AND group_step>#{group_step}")
	public void boardStepIncrement(BoardVO vo);
	
	@SelectKey(keyProperty="no", resultType=int.class, before=true,
			statement="SELECT NVL(MAX(no)+1, 1) FROM replyBoard")
	@Insert("INSERT INTO replyBoard (no, name, email, subject, content, pwd, group_id, group_step, group_tab, root) "
			+ "VALUES(#{no}, #{name}, #{subject}, #{content}, #{pwd}, #{group_id}, #{group_step}, #{group_tab}, #{root})")
	public void boardReplyInsert(BoardVO vo);
	
	@Update("UPDATE replyBoard SET depth=depth+1 WHERE no=#{no}")
	public void boardDepthIncrement(int no);
}

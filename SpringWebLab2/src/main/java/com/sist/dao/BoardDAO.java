package com.sist.dao;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO {
	@Autowired
	private BoardMapper mapper;

	public List<BoardVO> boardListData(Map map) {
		return mapper.boardListData(map);
	}

	public int boardTotalPage() {
		return mapper.boardTotalPage();
	}

	public void boardInsert(BoardVO vo) {
		mapper.boardInsert(vo);
	}
}

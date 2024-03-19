package com.ssafy.board.dao;

import java.util.List;

import com.ssafy.board.model.BoardDto;

public interface BoardDao {

	int writeArticle(BoardDto boardDto);
	List<BoardDto> listArticle();
	BoardDto viewArticle(int articleNo);
	void updateHit(int articleNo);
	
}

package com.ssafy.board.model.service;

import java.util.List;
import java.util.Map;

import com.ssafy.board.model.BoardDto;
import com.ssafy.board.model.dao.BoardDao;
import com.ssafy.board.model.dao.BoardDaoImpl;
import com.ssafy.util.BoardSize;
import com.ssafy.util.PageNavigation;
import com.ssafy.util.SizeConstant;

public class BoardServiceImpl implements BoardService {

	private static BoardService boardService = new BoardServiceImpl();
	private BoardDao boardDao;

	private BoardServiceImpl() {
		boardDao = BoardDaoImpl.getBoardDao();
	}

	public static BoardService getBoardService() {
		return boardService;
	}

	@Override
	public void writeArticle(BoardDto boardDto) throws Exception {
		boardDao.writeArticle(boardDto);
	}

	@Override
	public List<BoardDto> listArticle(Map<String, Object> map) throws Exception {
		int pgno = (int) map.get("pgno");
//		int listSize = SizeConstant.LIST_SIZE;
		int listSize = BoardSize.LIST.getBoardSize();
		int start = (pgno - 1) * listSize;
		map.put("start", start);
		map.put("listsize", listSize);
		return boardDao.listArticle(map);
	}

	@Override
	public PageNavigation makePageNavigation(Map<String, Object> map) throws Exception {
		PageNavigation pageNavigation = new PageNavigation();

		int currentPage = (int) map.get("pgno");
		int naviSize = BoardSize.NAVIGATION.getBoardSize();
		int listSize = BoardSize.LIST.getBoardSize();

		pageNavigation.setCurrentPage(currentPage);
		pageNavigation.setNaviSize(naviSize);
		int totalCount = boardDao.getTotalArticleCount(map);
		pageNavigation.setTotalCount(totalCount);
		int totalPageCount = (totalCount - 1) / listSize + 1;
		pageNavigation.setTotalPageCount(totalPageCount);
		boolean startRange = currentPage <= naviSize;
		pageNavigation.setStartRange(startRange);
		boolean endRange = (totalPageCount - 1) / naviSize * naviSize < currentPage;
		pageNavigation.setEndRange(endRange);
		pageNavigation.makeNavigator();
		return pageNavigation;
	}

	@Override
	public BoardDto getArticle(int articleNo) throws Exception {
		return boardDao.getArticle(articleNo);
	}

	@Override
	public void updateHit(int articleNo) throws Exception {
		boardDao.updateHit(articleNo);
	}

	@Override
	public void modifyArticle(BoardDto boardDto) throws Exception {
		// TODO : BoardDaoImpl의 modifyArticle 호출

	}

	@Override
	public void deleteArticle(int articleNo) throws Exception {
		// TODO : BoardDaoImpl의 deleteArticle
	}

}

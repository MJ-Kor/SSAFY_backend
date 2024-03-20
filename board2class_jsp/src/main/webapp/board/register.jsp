<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.ssafy.board.model.BoardDto,com.ssafy.board.dao.BoardDaoImpl"%>
<%
//1. 작성자아이디, 글제목, 글내용을 얻으세요. 
BoardDto boardDto = new BoardDto();
boardDto.setUserId(request.getParameter("userid"));
boardDto.setSubject(request.getParameter("subject"));
boardDto.setContent(request.getParameter("content"));

//2. 1의 data를 BoardDao의 writeArticle(BoardDto)메소드에 전달하고 DB에 insert 하세요.
int cnt = BoardDaoImpl.getBoardDao().writeArticle(boardDto); // 0 or 1

if(cnt != 0) {
	response.sendRedirect(request.getContextPath() + "/board/register_success.jsp");
} else {
	response.sendRedirect(request.getContextPath() + "/board/register_fail.jsp");
}
 %>         

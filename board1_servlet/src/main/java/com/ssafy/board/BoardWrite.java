package com.ssafy.board;

import java.io.IOException;

import com.ssafy.board.dao.BoardDaoImpl;
import com.ssafy.board.model.BoardDto;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/register")
public class BoardWrite extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardWrite() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 요청 받아서 파라미터 꺼내주기
		// userid, 글 제목, 글 내용
		String userid = request.getParameter("userid");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		System.out.println(userid);
		BoardDto board = new BoardDto();
		board.setUserId(userid);
		board.setSubject(subject);
		board.setContent(content);
		
		// 2. DB에 저장
		BoardDaoImpl.getInstance().writeArticle(board);
		
	}
	

}

package com.ssafy.board.controller;

import java.io.IOException;
import java.util.List;

import com.ssafy.board.dao.BoardDaoImpl;
import com.ssafy.board.model.BoardDto;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/article")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardController() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("리스트 들고 여기로");
		String action = request.getParameter("action");
		if(action.equals("list")) {
			// 1. 목록 가져오기 요청 처리 시키기 ==> service
			System.out.println("글 목록 요청 받음");
			List<BoardDto> list = BoardDaoImpl.getInstance().listArticle();
			System.out.println(list);
			// 2. 결과를 전달
			// 2-1. 화면에 전달.
			request.setAttribute("articles", list);
			// 3. jsp로 포워딩
			// Dispatcher 파견자
			RequestDispatcher dispatcher = request.getRequestDispatcher("/BoardList.jsp");
			dispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

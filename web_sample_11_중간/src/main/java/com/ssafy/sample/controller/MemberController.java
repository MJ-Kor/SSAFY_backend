package com.ssafy.sample.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.ssafy.sample.model.dto.MemberDto;
import com.ssafy.sample.model.service.MemberServiceImpl;

/**
 * Servlet implementation class MemberController
 */
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	MemberServiceImpl memberService = MemberServiceImpl.getMemberService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		
		System.out.println(action);
		try {
			if (action.equals("login")) {
				String id = request.getParameter("id");
				String pw = request.getParameter("password");
				System.out.println(id +" , "+pw);
				MemberDto member = memberService.login(id, pw);
				System.out.println(member);
				//session
				HttpSession session = request.getSession();
				session.setAttribute("userinfo", member);
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
				dispatcher.forward(request, response);
				
			} else if (action.equals("mvLogin")) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
				dispatcher.forward(request, response);
			} else if (action.equals("logout")) {
				HttpSession session = request.getSession();
				session.invalidate();
				response.sendRedirect(request.getContextPath());
				
			} 

		} catch (Exception e) {
			e.printStackTrace();
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/error.jsp");
			dispatcher.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package com.ssafy.member.controller;

import java.io.IOException;

import com.ssafy.member.model.service.MemberService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/user")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private MemberService memberService;

	public void init() {
		memberService = MemberServiceImpl.getMemberService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		String path = "";
		if(action.equals("mvlogin")) {
			path = "/user/login.jsp";
			response.sendRedirect(request.getContextPath() + path);
		} else if(action.equals("login")) {
			path = login(request, response);
			RequestDispatcher dispatcher = request.getRequestDispatcher(path);
			dispatcher.forward(request, response);
		} else if(action.equals("logout")) {
			path = logout(request, response);
			response.sendRedirect(request.getContextPath() + path);
		} else {
			response.sendRedirect(request.getContextPath() + path);
		}
	}

	private String logout(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}

	private String login(HttpServletRequest request, HttpServletResponse response) {
		String userId = request.getParameter("user_id");
		String userPwd = request.getParameter("user_pwd");
		MemberDto memberDto = memberService.loginMember(userId,userPwd);
		return null;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

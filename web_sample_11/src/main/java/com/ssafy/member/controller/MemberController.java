package com.ssafy.member.controller;

import java.io.IOException;

import com.ssafy.member.model.MemberDto;
import com.ssafy.member.model.service.MemberService;
import com.ssafy.member.model.service.MemberServiceImpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

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
		HttpSession session = request.getSession();
		session.invalidate();
		return "";
	}

	private String login(HttpServletRequest request, HttpServletResponse response) {
		String userId = request.getParameter("userid");
		String userPwd = request.getParameter("userpwd");
		System.out.println(userId);
		System.out.println(userPwd);
		try {
			MemberDto memberDto = memberService.loginMember(userId,userPwd);
			System.out.println(memberDto);
			if(memberDto != null) {
				HttpSession session = request.getSession();
				session.setAttribute("userinfo", memberDto);
				
				String idsave = request.getParameter("saveid");
				if("ok".equals(idsave)) {
					Cookie cookie = new Cookie("ssafy_id", userId);
					cookie.setPath(request.getContextPath());
					cookie.setMaxAge(60 * 60 * 24 * 365 * 40);
					response.addCookie(cookie);
				} else {
					Cookie cookies[] = request.getCookies();
					if(cookies != null) {
						for(Cookie cookie : cookies) {
							if("ssafy_id".equals(cookie.getName())) {
								cookie.setMaxAge(0);
								response.addCookie(cookie);
								break;
							}
						}
					}
				}
				return "/index.jsp";
			} else {
				request.setAttribute("msg", "아이디 또는 비밀번호 확인 후 다시 로그인하세요.");
				return "/user/login.jsp";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

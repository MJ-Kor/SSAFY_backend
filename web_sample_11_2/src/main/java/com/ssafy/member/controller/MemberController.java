package com.ssafy.member.controller;

import java.io.IOException;

import com.ssafy.member.model.MemberDto;
import com.ssafy.member.service.MemberService;
import com.ssafy.member.service.MemberServiceImpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/member")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private MemberService memberService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		memberService = MemberServiceImpl.getMemberService();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		String path = "";
		if(action.equals("login")) {
			path = login(request, response);
//			RequestDispatcher dispatcher = request.getRequestDispatcher(path);
//			dispatcher.forward(request, response);
			response.sendRedirect(request.getContextPath() + path);
		} else if(action.equals("logout")) {
			path = logout(request, response);
			response.sendRedirect(request.getContextPath() + path);
		} else if(action.equals("mvlogin")) {
			path = "/login.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(path);
			dispatcher.forward(request, response);
		}
	}


	private String logout(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		session.invalidate();
		return "/login.jsp";
	}


	private String login(HttpServletRequest request, HttpServletResponse response) {
		String user_id = request.getParameter("user_id");
		String user_password = request.getParameter("user_password");
		
		try {
			MemberDto memberDto = memberService.loginMember(user_id, user_password);
			System.out.println("memberDto: " + memberDto);
			if (memberDto != null) {
				
				// session 설정
				HttpSession session = request.getSession();
				session.setAttribute("userinfo", memberDto);
				
				// cookie 설정
				String idsave = request.getParameter("saveid");
				
				// 아이디 저장 체크
				if("ok".equals(idsave)) {
					Cookie cookie = new Cookie("ssafy_id", user_id);
					cookie.setPath(request.getContextPath());
					cookie.setMaxAge(60 * 60 * 24 * 365 * 40);
					response.addCookie(cookie);
				} else {
					Cookie cookies[] = request.getCookies();
					if(cookies != null) {
						for (Cookie cookie : cookies) {
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
				request.setAttribute("msg", "아이디 비번 다시 확인");
				return "/user/login.jsp";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "/error.jsp";
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

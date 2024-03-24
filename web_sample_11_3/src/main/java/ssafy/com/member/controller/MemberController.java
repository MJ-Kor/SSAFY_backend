package ssafy.com.member.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ssafy.com.member.model.MemberDto;
import ssafy.com.member.service.MemberService;
import ssafy.com.member.service.MemberServiceImpl;

/**
 * Servlet implementation class MemberController
 */
@WebServlet("/member")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private MemberService memberService;
	
	

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		memberService = MemberServiceImpl.getMemberService();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		String path = "";
		if(action.equals("login")) {
			path = login(request, response);
			RequestDispatcher rd = request.getRequestDispatcher(path);
			rd.forward(request, response);
			
		} else if(action.equals("mvlogin")) {
			path = "/member?action=login";
			response.sendRedirect(request.getContextPath() +  path);
					
		} else if(action.equals("logout")) {
			path = logout(request, response);
			response.sendRedirect(request.getContextPath() +  path);
		}
	}


	private String logout(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		session.invalidate();
		return "/member?action=login";
	}


	private String login(HttpServletRequest request, HttpServletResponse response) {
		String user_id = request.getParameter("user_id");
		String user_password = request.getParameter("user_password");
		MemberDto memberDto = null;
		
		try {
			memberDto = memberService.login(user_id, user_password);
			if(memberDto != null) {
				HttpSession session = request.getSession();
				session.setAttribute("userinfo", memberDto);
				
				String idsave = request.getParameter("saveid");
				if("ok".equals(idsave)) {
					Cookie cookie = new Cookie("ssafy_id", user_id);
					cookie.setPath(request.getContextPath());
					cookie.setMaxAge(60);
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
				request.setAttribute("msg", "회원 없음");
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

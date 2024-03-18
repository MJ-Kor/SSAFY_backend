package com.ssafy.hello;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/param")
public class ParameterTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ParameterTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		1. 이름, 비번, 과일을 get
		String name = request.getParameter("username");
		String pwd = request.getParameter("userpwd");
		String[] fruit = request.getParameterValues("fruit");
//		2. logic 처리
//		3. 응답페이지 작성 (html)
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
//		아래의 html을 요청자에게 보내줘야 함
		out.println("<html>");
		out.println("	<body>");
		out.println("		<h1>과일 선호도 조사</h1>");
		out.println(name + "(" + pwd + ")님이 좋아하는 과일은 ");
		if(fruit != null) {			
			for (int i = 0; i < fruit.length; i++) {
				out.println(fruit[i]);
				if(i != fruit.length - 1) {
					out.println(", ");
				}
			}
			out.println("입니다.");
		}else {
			out.println("없습니다.");
		}
		out.println("	</body>");
		out.println("</html>");
	}
}

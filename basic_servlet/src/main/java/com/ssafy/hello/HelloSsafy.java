package com.ssafy.hello;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class HelloSsafy extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public HelloSsafy() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.setCharacterEncoding("utf-8"); // 이거 쓸거면 html에 meta data 넣어야 함
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
//		아래의 html을 요청자에게 보내줘야 함
		out.println("<html>");
		out.println("	<body>");
		out.println("		<h1>Hello SSAFY !!!</h1>");
		out.println("		<h1>안녕 싸피</h1>");
		out.println("	</body>");
		out.println("</html>");
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}

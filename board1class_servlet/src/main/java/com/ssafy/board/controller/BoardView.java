package com.ssafy.board.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.ssafy.board.dao.BoardDaoImpl;
import com.ssafy.board.model.BoardDto;

@WebServlet("/view")
public class BoardView extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		1. data get (글번호) 
		int articleNo = Integer.parseInt(request.getParameter("article_no"));
		System.out.println(articleNo);

//		2. logic 처리
//		   - DAO에 1의 data를 이용하여 글번호에 해당하는 글정보 얻기
		BoardDto boardDto = BoardDaoImpl.getBoardDao().viewArticle(articleNo);
		
//		3. 2의 결과에 따른 응답페이지 작성.
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		if(boardDto != null) {
//			- 글번호에 해당하는 글의 조회수 증가
			BoardDaoImpl.getBoardDao().updateHit(articleNo);
			out.println("<!DOCTYPE html>");
			out.println("<html lang=\"ko\">");
			out.println("  <head>");
			out.println("    <meta charset=\"UTF-8\" />");
			out.println("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />");
			out.println("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />");
			out.println("    <link");
			out.println("      href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css\"");
			out.println("      rel=\"stylesheet\"");
			out.println("      integrity=\"sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN\"");
			out.println("      crossorigin=\"anonymous\"");
			out.println("    />");
			out.println("    <link href=\"../assets/css/app.css\" rel=\"stylesheet\" />");
			out.println("    <title>SSAFY</title>");
			out.println("  </head>");
			out.println("  <body>");
			out.println("    <div class=\"container\">");
			out.println("      <div class=\"row justify-content-center\">");
			out.println("        <div class=\"col-lg-8 col-md-10 col-sm-12\">");
			out.println("          <h2 class=\"my-3 py-3 shadow-sm bg-light text-center\">");
			out.println("            <mark class=\"sky\">글보기</mark>");
			out.println("          </h2>");
			out.println("        </div>");
			out.println("        <div class=\"col-lg-8 col-md-10 col-sm-12\">");
			out.println("          <div class=\"row my-2\">");
			out.println("            <h2 class=\"text-secondary px-5\">" + boardDto.getSubject() + "</h2>");
			out.println("          </div>");
			out.println("          <div class=\"row\">");
			out.println("            <div class=\"col-md-8\">");
			out.println("              <div class=\"clearfix align-content-center\">");
			out.println("                <img");
			out.println("                  class=\"avatar me-2 float-md-start bg-light p-2\"");
			out.println("                  src=\"https://raw.githubusercontent.com/twbs/icons/main/icons/person-fill.svg\"");
			out.println("                />");
			out.println("                <p>");
			out.println("                  <span class=\"fw-bold\">안효인</span> <br />");
			out.println("                  <span class=\"text-secondary fw-light\"> " + boardDto.getRegisterTime() + " 조회 : " + boardDto.getHit() + " </span>");
			out.println("                </p>");
			out.println("              </div>");
			out.println("            </div>");
			out.println("            <div class=\"col-md-4 align-self-center text-end\">댓글 : 17</div>");
			out.println("            <div class=\"divider mb-3\"></div>");
			out.println("            <div class=\"text-secondary\">");
			out.println(boardDto.getContent());
			out.println("            </div>");
			out.println("            <div class=\"divider mt-3 mb-3\"></div>");
			out.println("            <div class=\"d-flex justify-content-end\">");
			out.println("              <button type=\"button\" id=\"btn-list\" class=\"btn btn-outline-primary mb-3\">");
			out.println("                글목록");
			out.println("              </button>");
			out.println("              <button type=\"button\" id=\"btn-mv-modify\" class=\"btn btn-outline-success mb-3 ms-1\">");
			out.println("                글수정");
			out.println("              </button>");
			out.println("              <button type=\"button\" id=\"btn-delete\" class=\"btn btn-outline-danger mb-3 ms-1\">");
			out.println("                글삭제");
			out.println("              </button>");
			out.println("            </div>");
			out.println("          </div>");
			out.println("        </div>");
			out.println("      </div>");
			out.println("    </div>");
			out.println("    <script");
			out.println("      src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js\"");
			out.println("      integrity=\"sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL\"");
			out.println("      crossorigin=\"anonymous\"");
			out.println("    ></script>");
			out.println("    <script>");
			out.println("      document.querySelector(\"#btn-list\").addEventListener(\"click\", function () {");
			out.println("        location.href = \"/board/list\";");
			out.println("      });");
			out.println("      document.querySelector(\"#btn-mv-modify\").addEventListener(\"click\", function () {");
			out.println("        alert(\"글수정하자!!!\");");
			out.println("        location.href = \"\";");
			out.println("      });");
			out.println("      document.querySelector(\"#btn-delete\").addEventListener(\"click\", function () {");
			out.println("        alert(\"글삭제하자!!!\");");
			out.println("        location.href = \"\";");
			out.println("      });");
			out.println("    </script>");
			out.println("  </body>");
			out.println("</html>");
		} else {
			System.out.println("여기 왔니???");
			out.println("<script>");
			out.println("alert('그런 글번호 없어!!!');");
			out.println("location.href=\"/board/list\"");
			out.println("</script>");
		}
		

	}

}

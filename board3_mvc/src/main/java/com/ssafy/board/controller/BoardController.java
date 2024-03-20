package com.ssafy.board.controller;

import java.io.IOException;
import java.util.List;

import com.ssafy.board.model.BoardDto;
import com.ssafy.board.model.service.BoardService;
import com.ssafy.board.model.service.BoardServiceImpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/article")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BoardService boardService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		boardService = BoardServiceImpl.getBoardService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		System.out.println("action:" + action);
		String path = "";
		if ("list".equals(action)) {
			path = list(request, response);
			forward(request, response, path);
		} else if ("view".equals(action)) {
			path = view(request, response);
			forward(request, response, path);
		} else if ("mvwrite".equals(action)) {
			path = "/board/write.jsp";
			redirect(request, response, path);
		} else if ("write".equals(action)) {
			path = write(request, response);
			redirect(request, response, path);
		} else if ("mvmodify".equals(action)) {
			path = mvModify(request, response);
			forward(request, response, path);
		} else if ("modify".equals(action)) {
			path = modify(request, response);
			forward(request, response, path);
		} else if ("delete".equals(action)) {
			path = delete(request, response);
			redirect(request, response, path);
		} else if ("search".equals(action)) {
			path = search(request, response);
			forward(request, response, path);
		} else {
			redirect(request, response, path);
		}
	}
	


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

	private void forward(HttpServletRequest request, HttpServletResponse response, String path)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}

	private void redirect(HttpServletRequest request, HttpServletResponse response, String path) throws IOException {
		response.sendRedirect(request.getContextPath() + path);
	}

	private String list(HttpServletRequest request, HttpServletResponse response) {
		try {
			System.out.println("확인용");
			List<BoardDto> list = boardService.listArticle();
			request.setAttribute("articles", list);

			return "/board/list.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			return "/index.jsp";
		}
	}
	
	private String search(HttpServletRequest request, HttpServletResponse response) {
		try {
			System.out.println("서치");
			String key = request.getParameter("key");
			String search_word = request.getParameter("search-word");
			System.out.println("key:"+key);
			System.out.println("search_word:"+search_word);
			if(key.equals("검색조건")) {
				return "/article?action=list";
			}
			else {
				List<BoardDto> list = boardService.searchArticle(key, search_word);
				request.setAttribute("articles", list);
				return "/board/list.jsp";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "/index.jsp";
		}
	}

	private String view(HttpServletRequest request, HttpServletResponse response) {
		int articleNo = Integer.parseInt(request.getParameter("articleNo"));
		try {
			BoardDto boardDto = boardService.getArticle(articleNo);
			boardService.updateHit(articleNo);
			request.setAttribute("article", boardDto);

			return "/board/view.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			return "/index.jsp";
		}
	}

	private String write(HttpServletRequest request, HttpServletResponse response) {
		BoardDto boardDto = new BoardDto();
		boardDto.setUserId(request.getParameter("userid"));
		boardDto.setSubject(request.getParameter("subject"));
		boardDto.setContent(request.getParameter("content"));
		try {
			boardService.writeArticle(boardDto);
			return "/article?action=list";
		} catch (Exception e) {
			e.printStackTrace();
			return "/index.jsp";
		}
	}

	private String mvModify(HttpServletRequest request, HttpServletResponse response) {
		// TODO : 수정하고자하는 글의 글번호를 얻는다.
		int articleNo = Integer.parseInt(request.getParameter("articleNo"));
		
		// TODO : 글번호에 해당하는 글정보를 얻고 글정보를 가지고 modify.jsp로 이동.
		try {
			BoardDto boardDto = boardService.getArticle(articleNo);
			request.setAttribute("article", boardDto);
			return "/board/modify.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			return "/index.jsp";
		}
	}

	private String modify(HttpServletRequest request, HttpServletResponse response) {
		// TODO : 수정 할 글정보를 얻고 BoardDto에 set.
		BoardDto boardDto = new BoardDto();
		int articleNo = Integer.parseInt(request.getParameter("articleNo"));
		String userid = request.getParameter("userid");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		
		boardDto.setArticleNo(articleNo);
		boardDto.setUserId(userid);
		boardDto.setSubject(subject);
		boardDto.setContent(content);
		
		try {
			// TODO : boardDto를 파라미터로 service의 modifyArticle() 호출.
			// TODO : 글수정 완료 후 view.jsp로 이동.(이후의 프로세스를 생각해 보세요.)
			boardService.modifyArticle(boardDto);
//			request.setAttribute("article", boardDto);
			System.out.println(Integer.parseInt(request.getParameter("articleNo")));
			return view(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "/index.jsp";
		}
	}

	private String delete(HttpServletRequest request, HttpServletResponse response) {
		// TODO : 삭제할 글 번호를 얻는다.
		int articleNo = Integer.parseInt(request.getParameter("articleNo"));
		try {
			// TODO : 글번호를 파라미터로 service의 deleteArticle()을 호출.
			boardService.deleteArticle(articleNo);
			return "/article?action=list";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "/index.jsp";
		}
	}

}

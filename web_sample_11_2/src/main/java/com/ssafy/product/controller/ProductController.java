package com.ssafy.product.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.product.model.ProductDto;
import com.ssafy.product.service.ProductService;
import com.ssafy.product.service.ProductServiceImpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/board")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ProductService productService;
	

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		productService = ProductServiceImpl.getProductService();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		String path = "";
		
		if(action.equals("list")) {
			path = list(request, response);
			RequestDispatcher dispatcher = request.getRequestDispatcher(path);
			dispatcher.forward(request, response);
			
		} else if(action.equals("view")) {
			path = view(request, response);
			RequestDispatcher dispatcher = request.getRequestDispatcher(path);
			dispatcher.forward(request, response);
			
		} else if(action.equals("mvwrite")) {
			path = "/product/regist.jsp";
			response.sendRedirect(request.getContextPath() + path);
			
		} else if(action.equals("write")) {
			path = write(request, response);
			response.sendRedirect(request.getContextPath() + path);
			
		} else if(action.equals("mvmodify")) {
			path = mvmodify(request, response);
			RequestDispatcher dispatcher = request.getRequestDispatcher(path);
			dispatcher.forward(request, response);
			
		} else if(action.equals("modify")) {
			path = modify(request, response);
			RequestDispatcher dispatcher = request.getRequestDispatcher(path);
			dispatcher.forward(request, response);
			
		} else if(action.equals("delete")) {
			path = delete(request, response);
			response.sendRedirect(request.getContextPath() + path);
			
		} else if(action.equals("search")) {
			path = search(request, response);
			RequestDispatcher dispatcher = request.getRequestDispatcher(path);
			dispatcher.forward(request, response);
		}
	}

	private String list(HttpServletRequest request, HttpServletResponse response) {
		List<ProductDto> list = new ArrayList<>();
		try {
			list = productService.getArticleList();
			request.setAttribute("products", list);
			return "/product/list.jsp";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "/index.jsp";
		}
	}

	private String view(HttpServletRequest request, HttpServletResponse response) {
		String code = request.getParameter("productCode");
		System.out.println(code);
		ProductDto product = new ProductDto();
		try {
			product = productService.getArticle(code);
			System.out.println("result get article: " + product);
			request.setAttribute("product", product);
			return "/product/view.jsp";
					
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "/index.jsp";
		}
	}

	private String write(HttpServletRequest request, HttpServletResponse response) {
		ProductDto product = new ProductDto();
		int cnt = 0;
		product.setCode(request.getParameter("code"));
		product.setModel(request.getParameter("model"));
		product.setPrice(Integer.parseInt(request.getParameter("price")));
		try {
			cnt = productService.writeArticle(product);
			if(cnt == 0) {
				return "실패 시 페이지";
			} else {
				return "/board?action=list";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "/index.jsp";
		}
	}
	
	private String mvmodify(HttpServletRequest request, HttpServletResponse response) {
		String productCode = request.getParameter("productCode");
		try {
			ProductDto productDto = productService.getArticle(productCode);
			request.setAttribute("product", productDto);
			return "/product/modify.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			return "/index.jsp";
		}
	}

	private String modify(HttpServletRequest request, HttpServletResponse response) {
		ProductDto product = new ProductDto();
		int cnt = 0;
		product.setCode(request.getParameter("code"));
		product.setModel(request.getParameter("model"));
		product.setPrice(Integer.parseInt(request.getParameter("price")));
		try {
			cnt = productService.writeArticle(product);
			if(cnt == 0) {
				return "실패 시 페이지";
			} else {
				return view(request, response);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "/index.jsp";
		}
	}

	private String delete(HttpServletRequest request, HttpServletResponse response) {
		String code = request.getParameter("code");
		int cnt = 0;
		try {
			cnt = productService.deleteArticle(code);
			if(cnt == 0) {
				return "실패 시 페이지";
			} else {
				return "/board?action=list";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "/index.jsp";
		}
	}

	private String search(HttpServletRequest request, HttpServletResponse response) {
		List<ProductDto> list = new ArrayList<>();

		String key = request.getParameter("key");
		String searchWord = request.getParameter("searchWord");
		System.out.println(key);
		System.out.println(searchWord);
		try {
			list = productService.searchArticle(key, searchWord);
			System.out.println(list);
			request.setAttribute("products", list);
			return "/product/list.jsp";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "/index.jsp";
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}

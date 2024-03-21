package com.ssafy.product.controller;

import java.io.IOException;
import java.util.List;

import com.ssafy.product.model.ProductDto;
import com.ssafy.product.model.service.ProductService;
import com.ssafy.product.model.service.ProductServiceImpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/product")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ProductService productService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		productService = ProductServiceImpl.getProductService();
		
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		System.out.println(action);
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
			RequestDispatcher dispatcher = request.getRequestDispatcher(path);
			dispatcher.forward(request, response);
			
		} else if(action.equals("search")) {
			path = search(request, response); 
			RequestDispatcher dispatcher = request.getRequestDispatcher(path);
			dispatcher.forward(request, response);
		}
	}


	private String view(HttpServletRequest request, HttpServletResponse response) {
		String productCode = request.getParameter("productCode");
		try {
			ProductDto productDto = productService.getProduct(productCode);
			request.setAttribute("product", productDto);
			return "/product/view.jsp";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "/index.jsp";
		}
	}


	private String search(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}


	private String delete(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}


	private String modify(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}


	private String mvmodify(HttpServletRequest request, HttpServletResponse response) {
		
		return null;
	}


	private String write(HttpServletRequest request, HttpServletResponse response) {
		ProductDto productDto = new ProductDto();
		productDto.setCode(request.getParameter("productCode"));
		productDto.setModel(request.getParameter("model"));
		productDto.setPrice(Integer.parseInt(request.getParameter("price")));
		try {
			System.out.println("갔나?");
			productService.writeProduct(productDto);
			return "/product?action=list";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "/index.jsp";
		}
	}


	private String list(HttpServletRequest request, HttpServletResponse response) {
		try {
			List<ProductDto> productList = productService.getProductList();
			request.setAttribute("products", productList);
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

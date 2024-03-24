package com.ssafy.sample.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.ssafy.sample.model.dto.ProductDto;
import com.ssafy.sample.model.service.ProductServiceImpl;

/**
 * Servlet implementation class ProductController
 */
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
	ProductServiceImpl service = ProductServiceImpl.getProductService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		try {
			if (action.equals("list")) {
				List<ProductDto> list = service.selectAll();
				request.setAttribute("list", list);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/product/list.jsp");
				dispatcher.forward(request, response);
			} else if (action.equals("view")) {
				//제품 정보 보기
			} else if (action.equals("mvInsert")) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/product/regist.jsp");
				dispatcher.forward(request, response);
			} else if (action.equals("insert")) {
				ProductDto product = new ProductDto();
				product.setCode(request.getParameter("productCode"));
				product.setModel(request.getParameter("model"));
				product.setPrice(Integer.parseInt(request.getParameter("price")));
				
				service.insert(product);
				
				response.sendRedirect(request.getContextPath()+"/product?action=list");
			}else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
				dispatcher.forward(request, response);
			}
			

		} catch (Exception e) {
			//에러 페이지 처리
			e.printStackTrace();
			RequestDispatcher dispatcher = request.getRequestDispatcher("/error.jsp");
			dispatcher.forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

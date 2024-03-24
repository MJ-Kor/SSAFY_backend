package ssafy.com.product.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ssafy.com.product.model.ProductDto;
import ssafy.com.product.service.ProductService;
import ssafy.com.product.service.ProductServiceImpl;

/**
 * Servlet implementation class ProductController
 */
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
			RequestDispatcher rd = request.getRequestDispatcher(path);
			rd.forward(request, response);
		} else if(action.equals("search")) {
			path = search(request, response);
			RequestDispatcher rd = request.getRequestDispatcher(path);
			rd.forward(request, response);
		} else if(action.equals("add")) {
			path = add(request, response);
			response.sendRedirect(request.getContextPath() + path);
		} else if(action.equals("mvadd")) {
			path = "/product/regist.jsp";
			response.sendRedirect(request.getContextPath() + path);
		} else if(action.equals("modify")) {
			path = modify(request, response);
			RequestDispatcher rd = request.getRequestDispatcher(path);
			rd.forward(request, response);
		} else if(action.equals("mvmodify")) {
			path = "/product/modify.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(path);
			rd.forward(request, response);
		} else if(action.equals("view")) {
			path = view(request, response);
			RequestDispatcher rd = request.getRequestDispatcher(path);
			rd.forward(request, response);
		} else if(action.equals("search")) {
			path = delete(request, response);
			response.sendRedirect(request.getContextPath() + path);
		} else if(action.equals("error")) {
			path = "/error.jsp";
			response.sendRedirect(request.getContextPath() + path);
		} 
	}

	private String list(HttpServletRequest request, HttpServletResponse response) {
		List<ProductDto> list = new ArrayList<>();
		try {
			list = productService.getAllList();
			request.setAttribute("products", list);
			return "/product/list.jsp";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "/error.jsp";
		}
	}

	private String search(HttpServletRequest request, HttpServletResponse response) {
		
		String key = request.getParameter("key");
		String searchWord = request.getParameter("searchWord");
		List<ProductDto> list = new ArrayList<>();
		try {
			if(key.equals("검색 조건")) {
				list = productService.getAllList();
				request.setAttribute("products", list);
				return "/product/list.jsp";
			} else {
				list = productService.getSearchedList(key, searchWord);
				request.setAttribute("products", list);
				return "/product/list.jsp";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "/error.jsp";
		}
	}

	private String add(HttpServletRequest request, HttpServletResponse response) {
		int cnt = 0;
		String code = request.getParameter("code");
		String model = request.getParameter("model");
		String price = request.getParameter("price");
		ProductDto productDto = new ProductDto();
		productDto.setCode(code);
		productDto.setCode(model);
		productDto.setCode(price);
		try {
			cnt = productService.addProduct(productDto);
			if(cnt != 0) {
				return "/board?action=list";
			} else {
				return "/board?action=error";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "/error.jsp";
		}
	}

	private String modify(HttpServletRequest request, HttpServletResponse response) {
		int cnt = 0;
		String code = request.getParameter("code");
		String model = request.getParameter("model");
		String price = request.getParameter("price");
		ProductDto productDto = new ProductDto();
		productDto.setCode(code);
		productDto.setCode(model);
		productDto.setCode(price);
		try {
			cnt = productService.addProduct(productDto);
			if(cnt != 0) {
				return "/board?action=list";
			} else {
				return "/board?action=error";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "/error.jsp";
		}
	}

	private String view(HttpServletRequest request, HttpServletResponse response) {
		String code = request.getParameter("code");
		ProductDto productDto = new ProductDto();
		try {
			productDto = productService.getProduct(code);
			request.setAttribute("product", productDto);
			return "/product/view.jsp";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "/error.jsp";
		}
	}

	private String delete(HttpServletRequest request, HttpServletResponse response) {
		String code = request.getParameter("code");
		int cnt = 0;
		try {
			cnt = productService.deleteProduct(code);
			if(cnt != 0) {
				return "/board?action=list";
			} else {
				return "/board?action=error";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "/error.jsp";
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

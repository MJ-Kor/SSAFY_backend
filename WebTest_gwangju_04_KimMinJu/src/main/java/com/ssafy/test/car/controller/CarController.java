package com.ssafy.test.car.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.test.car.model.CarDto;
import com.ssafy.test.car.service.CarService;
import com.ssafy.test.car.service.CarServiceImpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CarController
 */
@WebServlet("/board")
public class CarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	private CarService carService;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		carService = CarServiceImpl.getCarService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		String path = "";
		
		if(action.equals("list")) {
			path = list(request, response);
			RequestDispatcher rd = request.getRequestDispatcher(path);
			rd.forward(request, response);
		} else if(action.equals("add")) {
			path = add(request, response);
			response.sendRedirect(request.getContextPath() + path);
		} else if(action.equals("mvadd")) {
			path = mvadd(request,response);
			RequestDispatcher rd = request.getRequestDispatcher(path);
			rd.forward(request, response);
		} else if(action.equals("modify")) {
			path = modify(request, response);
			RequestDispatcher rd = request.getRequestDispatcher(path);
			rd.forward(request, response);
		} else if(action.equals("mvmodify")) {
			path = mvmodify(request,response);
			RequestDispatcher rd = request.getRequestDispatcher(path);
			rd.forward(request, response);
		} else if(action.equals("delete")) {
			path = delete(request, response);
			response.sendRedirect(request.getContextPath() + path);
		} else if(action.equals("view")) {
			path = view(request, response);
			RequestDispatcher rd = request.getRequestDispatcher(path);
			rd.forward(request, response);
		} else {
			path = "/error.jsp";
			response.sendRedirect(request.getContextPath() + path);
		}
	}

	private String mvmodify(HttpServletRequest request, HttpServletResponse response) {
		String number = request.getParameter("number");
		try {
			CarDto carDto = carService.getCar(number);
			request.setAttribute("car", carDto);
			return "/car/update.jsp";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "/error.jsp";
		}
	}

	private String list(HttpServletRequest request, HttpServletResponse response) {
		List<CarDto> list = new ArrayList<>();
		try {
			list = carService.getAllList();
			request.setAttribute("cars", list);
			return "/car/list.jsp";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "/error.jsp";
		}
	}
	
	private String add(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String number = request.getParameter("number");
		String model = request.getParameter("model");
		String price = request.getParameter("price");
		String brand = request.getParameter("brand");
		String size = request.getParameter("size");
		CarDto carDto = new CarDto();
		carDto.setNumber(number);
		carDto.setModel(model);
		carDto.setPrice(price);
		carDto.setBrand(brand);
		carDto.setSize(size);
		int cnt = 0;
		try {
			cnt = carService.addCar(carDto);
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
	
	private String mvadd(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return "/car/regist.jsp";
	}

	private String modify(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String number = request.getParameter("number");
		String model = request.getParameter("model");
		String price = request.getParameter("price");
		String brand = request.getParameter("brand");
		String size = request.getParameter("size");
		CarDto carDto = new CarDto();
		carDto.setNumber(number);
		carDto.setModel(model);
		carDto.setPrice(price);
		carDto.setBrand(brand);
		carDto.setSize(size);
		int cnt = 0;
		try {
			cnt = carService.modifyCar(carDto);
			if(cnt != 0) {
				request.setAttribute("car", carDto);
				return view(request, response);
			} else {
				return "/board?action=error";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "/error.jsp";
		}
	}

	private String delete(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int cnt = 0;
		String number = request.getParameter("number");
		try {
			cnt = carService.deleteCar(number);
			if(cnt != 0) {
				return "/board?action=list";
			} else {
				System.out.println("여기");
				return "/board?action=error";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "/error.jsp";
		}
	}

	private String view(HttpServletRequest request, HttpServletResponse response) {
		String number = request.getParameter("number");
		CarDto carDto = new CarDto();
		try {
			carDto = carService.getCar(number);
			if(carDto != null) {
				request.setAttribute("car", carDto);
				return "/car/detail.jsp";
			} else {
				return "/error.jsp";
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

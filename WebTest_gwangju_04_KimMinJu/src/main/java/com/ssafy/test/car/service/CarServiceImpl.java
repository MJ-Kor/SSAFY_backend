package com.ssafy.test.car.service;

import java.util.List;

import com.ssafy.test.car.model.CarDto;
import com.ssafy.test.car.model.dao.CarDao;
import com.ssafy.test.car.model.dao.CarDaoImpl;

public class CarServiceImpl implements CarService {

	private static CarService carService = new CarServiceImpl();
	private CarDao carDao;
	private CarServiceImpl() {
		carDao = CarDaoImpl.getCarDao();
	}
	public static CarService getCarService() {
		return carService;
	}
	
	@Override
	public List<CarDto> getAllList() throws Exception {
		// TODO Auto-generated method stub
		return carDao.getAllList();
	}

	@Override
	public List<CarDto> getSearchedList(String key, String searchWord) throws Exception {
		// TODO Auto-generated method stub
		return carDao.getSearchedList(key, searchWord);
	}

	@Override
	public CarDto getCar(String number) throws Exception {
		// TODO Auto-generated method stub
		return carDao.getCar(number);
	}

	@Override
	public int addCar(CarDto carDto) throws Exception {
		// TODO Auto-generated method stub
		return carDao.addCar(carDto);
	}

	@Override
	public int deleteCar(String number) throws Exception {
		// TODO Auto-generated method stub
		return carDao.deleteCar(number);
	}

	@Override
	public int modifyCar(CarDto carDto) throws Exception {
		// TODO Auto-generated method stub
		return carDao.modifyCar(carDto);
	}

}

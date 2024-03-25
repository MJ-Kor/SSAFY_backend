package com.ssafy.test.car.service;

import java.util.List;

import com.ssafy.test.car.model.CarDto;

public interface CarService {
	List<CarDto> getAllList() throws Exception;
	List<CarDto> getSearchedList(String key, String searchWord) throws Exception;
	CarDto getCar(String number) throws Exception;
	int addCar(CarDto carDto) throws Exception;
	int deleteCar(String number) throws Exception;
	int modifyCar(CarDto carDto) throws Exception;
}

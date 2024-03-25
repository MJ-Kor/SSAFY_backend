package com.ssafy.test.car.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.test.car.model.CarDto;

public interface CarDao {
	List<CarDto> getAllList() throws SQLException;
	List<CarDto> getSearchedList(String key, String searchWord) throws SQLException;
	CarDto getCar(String number) throws SQLException;
	int addCar(CarDto carDto) throws SQLException;
	int deleteCar(String number) throws SQLException;
	int modifyCar(CarDto carDto) throws SQLException;
}

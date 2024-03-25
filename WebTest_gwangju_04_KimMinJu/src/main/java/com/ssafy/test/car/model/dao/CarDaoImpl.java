package com.ssafy.test.car.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;
import com.ssafy.test.car.model.CarDto;
import com.ssafy.test.util.DBUtil;

public class CarDaoImpl implements CarDao {
	
	private static CarDao carDao = new CarDaoImpl();
	private DBUtil dbUtil;
	private CarDaoImpl() {
		dbUtil = DBUtil.getInstance();
	}
	public static CarDao getCarDao() {
		return carDao;
	}
	@Override
	public List<CarDto> getAllList() throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<CarDto> list = new ArrayList<>();
		
		try {
			conn = dbUtil.getConnection();
			StringBuilder sql = new StringBuilder("select * from cars");
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				CarDto carDto = new CarDto();
				carDto.setNumber(rs.getString("number"));
				carDto.setModel(rs.getString("model"));
				carDto.setPrice(rs.getString("price"));
				carDto.setBrand(rs.getString("brand"));
				carDto.setSize(rs.getString("size"));
				
				list.add(carDto);
			}
		} finally {
			dbUtil.close(rs, pstmt, conn);
		}
		return list;
	}

	@Override
	public List<CarDto> getSearchedList(String key, String searchWord) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CarDto getCar(String number) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		CarDto carDto = new CarDto();
		
		try {
			conn = dbUtil.getConnection();
			StringBuilder sql = new StringBuilder("select * from cars where number = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, number);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				carDto.setNumber(rs.getString("number"));
				carDto.setModel(rs.getString("model"));
				carDto.setPrice(rs.getString("price"));
				carDto.setBrand(rs.getString("brand"));
				carDto.setSize(rs.getString("size"));
			}
		} finally {
			dbUtil.close(rs, pstmt, conn);
		}
		return carDto;
	}

	@Override
	public int addCar(CarDto carDto) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		
		try {
			conn = dbUtil.getConnection();
			StringBuilder sql = new StringBuilder("insert into cars (number, model, price, brand, size) \n");
			sql.append("values (?,?,?,?,?)");
			System.out.println(sql);
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, carDto.getNumber());
			pstmt.setString(2, carDto.getModel());
			pstmt.setString(3, carDto.getPrice());
			pstmt.setString(4, carDto.getBrand());
			pstmt.setString(5, carDto.getSize());
			cnt = pstmt.executeUpdate();

		} finally {
			dbUtil.close(pstmt, conn);
		}
		return cnt;
	}

	@Override
	public int deleteCar(String number) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		
		
		try {
			conn = dbUtil.getConnection();
			StringBuilder sql = new StringBuilder("delete from cars where number = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, number);
			System.out.println(pstmt);
			cnt = pstmt.executeUpdate();

		} finally {
			dbUtil.close(pstmt, conn);
		}
		return cnt;
	}

	@Override
	public int modifyCar(CarDto carDto) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		
		try {
			conn = dbUtil.getConnection();
			StringBuilder sql = new StringBuilder("update cars set model=?, price=?, brand=?, size=? \n");
			sql.append("where number = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, carDto.getModel());
			pstmt.setString(2, carDto.getPrice());
			pstmt.setString(3, carDto.getBrand());
			pstmt.setString(4, carDto.getSize());
			pstmt.setString(5, carDto.getNumber());
			cnt = pstmt.executeUpdate();

		} finally {
			dbUtil.close(pstmt, conn);
		}
		return cnt;
	}

}

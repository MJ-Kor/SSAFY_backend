package com.ssafy.product.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.product.model.ProductDto;
import com.ssafy.sample.util.DBUtil;

public class ProductDaoImpl implements ProductDao {

	private static ProductDao productDao;
	private static DBUtil dbUtil;
	private ProductDaoImpl() {
		dbUtil = DBUtil.getInstance();
	}
	
	public static ProductDao getProductDao() {
		if(productDao == null) {
			productDao = new ProductDaoImpl();
			
		}
		return productDao;
	}
	
	@Override
	public List<ProductDto> getProductList() throws SQLException {
		List<ProductDto> productList = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = dbUtil.getConnection();
			StringBuilder sql = new StringBuilder("select code, model, price from product");
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ProductDto productDto= new ProductDto();
				productDto.setCode(rs.getString("code"));
				productDto.setModel(rs.getString("model"));
				productDto.setPrice(rs.getInt("price"));
				productList.add(productDto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbUtil.close(rs, pstmt, conn);
		}
		return productList;
	}

	@Override
	public void writeProduct(ProductDto productDto) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt= null;
		
		try {			
			conn = dbUtil.getConnection();
			StringBuilder sql = new StringBuilder("insert into product (code, model, price) \n");
			sql.append("values (?, ?, ?)");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, productDto.getCode());
			pstmt.setString(2, productDto.getModel());
			pstmt.setInt(3, productDto.getPrice());
			
			pstmt.executeUpdate();
		} finally {
			dbUtil.close(pstmt, conn);
		}
	}

	@Override
	public void modifyProduct() throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteProduct() throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ProductDto> getSearchedList() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductDto getProduct(String productCode) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ProductDto productDto = null;
		try {			
			conn = dbUtil.getConnection();
			StringBuilder sql = new StringBuilder("select code, model, price from product \n");
			sql.append("where code = " + "'" + productCode + "'");
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				productDto = new ProductDto();
				productDto.setCode(rs.getString("code"));
				productDto.setModel(rs.getString("model"));
				productDto.setPrice(rs.getInt("price"));
			}
		} finally {
			dbUtil.close(rs, pstmt, conn);
		}
		return productDto;
	}

}

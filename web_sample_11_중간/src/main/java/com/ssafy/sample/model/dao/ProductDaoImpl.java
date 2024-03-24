package com.ssafy.sample.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.sample.model.dto.ProductDto;
import com.ssafy.sample.util.DBUtil;

public class ProductDaoImpl {
	
	private ProductDaoImpl() {
		// TODO Auto-generated constructor stub
	}
	
	private static ProductDaoImpl instance = new ProductDaoImpl();
	public static ProductDaoImpl getProductDao() {
		return instance;
	}
	
	public List<ProductDto> selectAll(){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ProductDto> list = new ArrayList<>();
		try {
			conn = DBUtil.getInstance().getConnection();
			String sql = "select * from product;";
			
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ProductDto product = new ProductDto();
				product.setCode(rs.getString("code"));
				product.setModel(rs.getString("model"));
				product.setPrice(rs.getInt("price"));
				list.add(product);
			}
			System.out.println(list);
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			DBUtil.getInstance().close(rs, pstmt, conn);
		}
		
		return list;
	}
	
	public ProductDto selectProduct(String code) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ProductDto product = new ProductDto();
		try {
			conn = DBUtil.getInstance().getConnection();
			String sql  =" select * from product where code = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, code);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				product.setCode(rs.getString("code"));
				product.setModel(rs.getString("model"));
				product.setPrice(rs.getInt("price"));
			}

		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			DBUtil.getInstance().close(rs, pstmt, conn);
		}
		return product;
	}
	
	public void update(ProductDto product) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getInstance().getConnection();
			//업데이트 코드 짜야함
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			DBUtil.getInstance().close(null);
		}
	}
	
	public void insert(ProductDto product) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtil.getInstance().getConnection();
			String sql = " insert into product(code, model, price) values (?, ?, ?);";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, product.getCode());
			pstmt.setString(2, product.getModel());
			pstmt.setInt(3, product.getPrice());
			
			int cnt =pstmt.executeUpdate();
			System.out.println(cnt);
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			DBUtil.getInstance().close(pstmt, conn);
		}
	}
	
	public void delete(String code) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getInstance().getConnection();
			//삭제 코드 짜야함
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			DBUtil.getInstance().close(null);
		}
	}

}

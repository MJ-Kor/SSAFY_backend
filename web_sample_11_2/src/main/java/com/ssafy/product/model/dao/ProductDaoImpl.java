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

	private static ProductDao productDao = new ProductDaoImpl();
	private static DBUtil dbUtil;
	
	private ProductDaoImpl() {
		dbUtil = DBUtil.getInstance();
	}

	public static ProductDao getProductDao() {
		return productDao;
	}
	
	@Override
	public List<ProductDto> getArticleList() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ProductDto> list = new ArrayList<>();
		
		try {
			conn = dbUtil.getConnection();
			StringBuilder sql = new StringBuilder("select * from product");
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ProductDto productDto = new ProductDto();
				productDto.setCode(rs.getString("code"));
				productDto.setModel(rs.getString("model"));
				productDto.setPrice(rs.getInt("price"));
				
				list.add(productDto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbUtil.close(rs, pstmt, conn);
		}
		return list;
	}

	@Override
	public ProductDto getArticle(String code) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ProductDto productDto = new ProductDto();
		try {
			conn = dbUtil.getConnection();
			StringBuilder sql = new StringBuilder("select * from product where code = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, code);
			rs = pstmt.executeQuery();
			if(rs.next()){
				productDto.setCode(rs.getString("code"));
				productDto.setModel(rs.getString("model"));
				productDto.setPrice(rs.getInt("price"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbUtil.close(rs, pstmt, conn);
		}
		return productDto;
	}

	@Override
	public int writeArticle(ProductDto productDto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		try {
			conn = dbUtil.getConnection();
			StringBuilder sql = new StringBuilder("insert into product (code, model, price) \n");
			sql.append("values (?, ?, ?)");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, productDto.getCode());
			pstmt.setString(2, productDto.getModel());
			pstmt.setInt(3, productDto.getPrice());
			
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbUtil.close(pstmt, conn);
		}
		return cnt;
	}

	@Override
	public int deleteArticle(String code) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		try {
			conn = dbUtil.getConnection();
			StringBuilder sql = new StringBuilder("delete from product where code = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, code);
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbUtil.close(pstmt, conn);
		}
		return cnt;
	}

	@Override
	public int modifyArticle(ProductDto productDto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		try {
			conn = dbUtil.getConnection();
			StringBuilder sql = new StringBuilder("update product set model = ?, price=? \n");
			sql.append("where code = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, productDto.getModel());
			pstmt.setInt(2, productDto.getPrice());
			pstmt.setString(3, productDto.getCode());
			
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbUtil.close(pstmt, conn);
		}
		return cnt;
	}

	@Override
	public List<ProductDto> searchArticle(String key, String searchWord) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ProductDto> list = new ArrayList<>();
		
		try {
			conn = dbUtil.getConnection();
			StringBuilder sql = new StringBuilder("select * from product where "+key+" = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, searchWord);
			System.out.println(pstmt);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ProductDto productDto = new ProductDto();
				productDto.setCode(rs.getString("code"));
				productDto.setModel(rs.getString("model"));
				productDto.setPrice(rs.getInt("price"));
				
				list.add(productDto);
				System.out.println(productDto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbUtil.close(rs, pstmt, conn);
		}
		return list;
	}

}

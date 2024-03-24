package ssafy.com.product.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.sample.util.DBUtil;

import ssafy.com.product.model.ProductDto;

public class ProductDaoImpl implements ProductDao {

	private static ProductDao productDao = new ProductDaoImpl();
	private DBUtil dbUtil;
	private ProductDaoImpl() {
		dbUtil = DBUtil.getInstance();
	}
	public static ProductDao getProductDao() {
		return productDao;
	}
	
	@Override
	public List<ProductDto> getAllList() throws SQLException {
		List<ProductDto> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = dbUtil.getConnection();
			StringBuilder sql = new StringBuilder("select * from product");
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ProductDto productDto = new ProductDto();
				productDto.setCode(rs.getString("code"));
				productDto.setModel(rs.getString("model"));
				productDto.setPrice(rs.getString("price"));
				
				list.add(productDto);
			}
		} finally {
			dbUtil.close(rs, pstmt, conn);
		}
		return list;
	}

	@Override
	public List<ProductDto> getSearchedList(String key, String searchWord) throws SQLException {
		List<ProductDto> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = dbUtil.getConnection();
			StringBuilder sql = new StringBuilder("select * from product where "+ key +"= ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, searchWord);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ProductDto productDto = new ProductDto();
				productDto.setCode(rs.getString("code"));
				productDto.setModel(rs.getString("model"));
				productDto.setPrice(rs.getString("price"));
				
				list.add(productDto);
			}
		} finally {
			dbUtil.close(rs, pstmt, conn);
		}
		return list;
	}

	@Override
	public ProductDto getProduct(String code) throws SQLException {
		ProductDto productDto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = dbUtil.getConnection();
			StringBuilder sql = new StringBuilder("select * from product where code = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, code);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				productDto = new ProductDto();
				productDto.setCode(rs.getString("code"));
				productDto.setModel(rs.getString("model"));
				productDto.setPrice(rs.getString("price"));
			}
		} finally {
			dbUtil.close(rs, pstmt, conn);
		}
		return productDto;
	}

	@Override
	public int deleteProduct(String code) throws SQLException {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = dbUtil.getConnection();
			StringBuilder sql = new StringBuilder("delete from product where code = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, code);
			cnt = pstmt.executeUpdate();
		} finally {
			dbUtil.close(pstmt, conn);
		}
		return cnt;
	}

	@Override
	public int modifyProduct(ProductDto productDto) throws SQLException {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = dbUtil.getConnection();
			StringBuilder sql = new StringBuilder("insert into product (code, model, price)\n");
			sql.append("values (?, ?, ?)");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, productDto.getCode());
			pstmt.setString(2, productDto.getModel());
			pstmt.setString(3, productDto.getPrice());
			cnt = pstmt.executeUpdate();
		} finally {
			dbUtil.close(pstmt, conn);
		}
		return cnt;
	}

	@Override
	public int addProduct(ProductDto productDto) throws SQLException {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = dbUtil.getConnection();
			StringBuilder sql = new StringBuilder("update product set model = ?, price = ? \n");
			sql.append("where code = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, productDto.getModel());
			pstmt.setString(2, productDto.getPrice());
			pstmt.setString(3, productDto.getCode());
			cnt = pstmt.executeUpdate();
		} finally {
			dbUtil.close(pstmt, conn);
		}
		return cnt;
	}

}

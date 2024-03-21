package com.ssafy.product.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.product.model.ProductDto;

public interface ProductDao {
	List<ProductDto> getProductList() throws SQLException;
	void writeProduct(ProductDto productDto) throws SQLException;
	void modifyProduct(ProductDto productDto) throws SQLException;
	void deleteProduct(String productCode) throws SQLException;
	List<ProductDto> getSearchedList(String key, String searchWord) throws SQLException;
	ProductDto getProduct(String productCode) throws SQLException;
}

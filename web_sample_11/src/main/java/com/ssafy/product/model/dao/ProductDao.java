package com.ssafy.product.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.product.model.ProductDto;

public interface ProductDao {
	List<ProductDto> getProductList() throws SQLException;
	void writeProduct(ProductDto productDto) throws SQLException;
	void modifyProduct() throws SQLException;
	void deleteProduct() throws SQLException;
	List<ProductDto> getSearchedList() throws SQLException;
	ProductDto getProduct(String productCode) throws SQLException;
}

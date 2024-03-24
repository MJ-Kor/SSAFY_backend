package com.ssafy.product.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.product.model.ProductDto;

public interface ProductDao {
	List<ProductDto> getArticleList() throws SQLException;
	ProductDto getArticle(String code) throws SQLException;
	int writeArticle(ProductDto productDto) throws SQLException;
	int deleteArticle(String code) throws SQLException;
	int modifyArticle(ProductDto productDto) throws SQLException;
	List<ProductDto>searchArticle(String key, String searchWord) throws SQLException;
}

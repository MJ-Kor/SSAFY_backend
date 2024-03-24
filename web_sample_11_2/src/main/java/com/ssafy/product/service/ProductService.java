package com.ssafy.product.service;

import java.util.List;

import com.ssafy.product.model.ProductDto;

public interface ProductService {
	List<ProductDto> getArticleList() throws Exception;
	ProductDto getArticle(String code) throws Exception;
	int writeArticle(ProductDto productDto) throws Exception;
	int deleteArticle(String code) throws Exception;
	int modifyArticle(ProductDto productDto) throws Exception;
	List<ProductDto>searchArticle(String key, String searchWord) throws Exception;
}

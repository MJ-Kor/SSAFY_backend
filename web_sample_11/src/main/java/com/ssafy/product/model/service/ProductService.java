 package com.ssafy.product.model.service;

import java.util.List;

import com.ssafy.product.model.ProductDto;

public interface ProductService {
	List<ProductDto> getProductList() throws Exception;
	void writeProduct(ProductDto productDto) throws Exception;
	void modifyProduct(ProductDto productDto) throws Exception;
	void deleteProduct(String productCode) throws Exception;
	List<ProductDto> getSearchedList(String key, String searchWord) throws Exception;
	ProductDto getProduct(String productCode) throws Exception;
}

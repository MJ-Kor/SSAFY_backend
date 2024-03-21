package com.ssafy.product.model.service;

import java.util.List;

import com.ssafy.product.model.ProductDto;
import com.ssafy.product.model.dao.ProductDao;
import com.ssafy.product.model.dao.ProductDaoImpl;

public class ProductServiceImpl implements ProductService {
	
	private static ProductService productService = new ProductServiceImpl();
	private ProductDao productDao;
	
	private ProductServiceImpl() {
		productDao = ProductDaoImpl.getProductDao(); 
	}
	
	public static ProductService getProductService() {
		return productService;
	}

	@Override
	public List<ProductDto> getProductList() throws Exception {
		return productDao.getProductList();
	}

	@Override
	public void writeProduct(ProductDto productDto) throws Exception {
		productDao.writeProduct(productDto);
	}

	@Override
	public void modifyProduct(ProductDto productDto) throws Exception {
		productDao.modifyProduct(productDto);
	}

	@Override
	public void deleteProduct(String productCode) throws Exception {
		productDao.deleteProduct(productCode);
	}

	@Override
	public List<ProductDto> getSearchedList(String key, String searchWord) throws Exception {
		return productDao.getSearchedList(key, searchWord);
	}

	@Override
	public ProductDto getProduct(String productCode) throws Exception {
		return productDao.getProduct(productCode);
	}
	
	
	
}

package com.ssafy.product.service;

import java.util.List;

import com.ssafy.product.model.ProductDto;
import com.ssafy.product.model.dao.ProductDao;
import com.ssafy.product.model.dao.ProductDaoImpl;

public class ProductServiceImpl implements ProductService {

	private ProductDao productDao;
	
	private ProductServiceImpl() {
		productDao = ProductDaoImpl.getProductDao();
	}
	
	private static ProductService productService = new ProductServiceImpl(); 
	
	public static ProductService getProductService() {
		return productService;
	}
	
	@Override
	public List<ProductDto> getArticleList() throws Exception {
		return productDao.getArticleList();
	}

	@Override
	public ProductDto getArticle(String code) throws Exception {
		// TODO Auto-generated method stub
		return productDao.getArticle(code);
	}

	@Override
	public int writeArticle(ProductDto productDto) throws Exception {
		// TODO Auto-generated method stub
		return productDao.writeArticle(productDto);
	}

	@Override
	public int deleteArticle(String code) throws Exception {
		// TODO Auto-generated method stub
		return productDao.deleteArticle(code);
	}

	@Override
	public int modifyArticle(ProductDto productDto) throws Exception {
		// TODO Auto-generated method stub
		return productDao.modifyArticle(productDto);
	}

	@Override
	public List<ProductDto> searchArticle(String key, String searchWord) throws Exception {
		// TODO Auto-generated method stub
		return productDao.searchArticle(key, searchWord);
	}
	

}

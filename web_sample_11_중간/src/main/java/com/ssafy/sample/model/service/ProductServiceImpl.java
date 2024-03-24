package com.ssafy.sample.model.service;

import java.util.List;

import com.ssafy.sample.model.dao.ProductDaoImpl;
import com.ssafy.sample.model.dto.ProductDto;

public class ProductServiceImpl {
	
	private ProductServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	
	private static ProductServiceImpl instance = new ProductServiceImpl();
	
	public static ProductServiceImpl getProductService() {
		return instance;
	}
	
	ProductDaoImpl productDao = ProductDaoImpl.getProductDao();
	
	/**
	 * 전체 조회
	 * @return 조회 된 상품 목록
	 */
	public List<ProductDto> selectAll(){
		return productDao.selectAll();
	}
	
	/**
	 * 상세 조회 
	 * @param code 상품 코드
	 * @return 상품 정보 
	 */
	public ProductDto selectProduct(String code) {
		return productDao.selectProduct(code);
	}
	
	/**
	 * 상품 정보 수정
	 * @param product 수정할 상품 정보
	 */
	public void update(ProductDto product) {
		productDao.update(product);
	}
	/**
	 * 상품 정보 등록
	 * @param product 등록할 상품정보
	 */
	public void insert(ProductDto product) {
		productDao.insert(product);
	}
	
	/**
	 * 상품 삭제
	 * @param code 삭제할 상품 코드
	 */
	public void delete(String code) {
		productDao.delete(code);
	}
	
	
	

}

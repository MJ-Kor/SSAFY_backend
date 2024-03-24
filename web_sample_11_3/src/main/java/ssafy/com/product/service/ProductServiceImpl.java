package ssafy.com.product.service;

import java.util.List;

import ssafy.com.product.model.ProductDto;
import ssafy.com.product.model.dao.ProductDao;
import ssafy.com.product.model.dao.ProductDaoImpl;

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
	public List<ProductDto> getAllList() throws Exception {
		// TODO Auto-generated method stub
		return productDao.getAllList();
	}

	@Override
	public List<ProductDto> getSearchedList(String key, String searchWord) throws Exception {
		// TODO Auto-generated method stub
		return productDao.getSearchedList(key, searchWord);
	}

	@Override
	public ProductDto getProduct(String code) throws Exception {
		// TODO Auto-generated method stub
		return productDao.getProduct(code);
	}

	@Override
	public int deleteProduct(String code) throws Exception {
		// TODO Auto-generated method stub
		return productDao.deleteProduct(code);
	}

	@Override
	public int modifyProduct(ProductDto productDto) throws Exception {
		// TODO Auto-generated method stub
		return productDao.modifyProduct(productDto);
	}

	@Override
	public int addProduct(ProductDto productDto) throws Exception {
		// TODO Auto-generated method stub
		return productDao.addProduct(productDto);
	}

}

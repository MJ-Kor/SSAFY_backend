package ssafy.com.product.service;

import java.sql.SQLException;
import java.util.List;

import ssafy.com.product.model.ProductDto;

public interface ProductService {
	List<ProductDto> getAllList() throws Exception;
	List<ProductDto> getSearchedList(String key, String searchWord) throws Exception;
	ProductDto getProduct(String code) throws Exception;
	int deleteProduct(String code) throws Exception;
	int modifyProduct(ProductDto productDto) throws Exception;
	int addProduct(ProductDto productDto) throws Exception;
}

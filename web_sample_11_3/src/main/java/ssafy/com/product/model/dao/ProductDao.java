package ssafy.com.product.model.dao;

import java.sql.SQLException;
import java.util.List;

import ssafy.com.product.model.ProductDto;

public interface ProductDao {
	List<ProductDto> getAllList() throws SQLException;
	List<ProductDto> getSearchedList(String key, String searchWord) throws SQLException;
	ProductDto getProduct(String code) throws SQLException;
	int deleteProduct(String code) throws SQLException;
	int modifyProduct(ProductDto productDto) throws SQLException;
	int addProduct(ProductDto productDto) throws SQLException;
	
}

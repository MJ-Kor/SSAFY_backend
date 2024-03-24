package ssafy.com.product.model;

public class ProductDto {
	private String code;
	private String model;
	private String price;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "ProductDto [code=" + code + ", model=" + model + ", price=" + price + "]";
	}
	
	
}

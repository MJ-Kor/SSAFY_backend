package com.ssafy.test.car.model;

public class CarDto {
	private String number;
	private String model;
	private String price;
	private String brand;
	private String size;
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
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
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	@Override
	public String toString() {
		return "CarDto [number=" + number + ", model=" + model + ", price=" + price + ", brand=" + brand + ", size="
				+ size + "]";
	}
	
}

package com.kh.dtoProduct;

public class productDTO {
	//필드 멤버변수
	private int productId;
	private String productName;
	private String category;
	private double price;
	private int stockQuantity;
	//생성자(기본, 파라미터값 입력)
	public productDTO() {
		
	}
	public productDTO(int productId, String productName, String category, double price, int stockQuantity) {
		this.productId = productId;
		this.productName = productName;
		this.category = category;
		this.price = price;
		this.stockQuantity = stockQuantity;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getStockQuantity() {
		return stockQuantity;
	}
	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}
	//@Override를 활용한 toString 메서드 추가.
	@Override
	public String toString() {
		return productName;
	}
}

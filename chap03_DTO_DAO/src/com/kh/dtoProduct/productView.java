package com.kh.dtoProduct;

import java.util.List;

public class productView {
	public void displayProducts(List<productDTO> products) {
		for(productDTO p : products) {
			System.out.println("Product ID : " + p.getProductId());
			System.out.println("Product Name : " + p.getProductName());
			System.out.println("Category : " + p.getCategory());
			System.out.println("Price : " + p.getPrice());
			System.out.println("Stock Quantity : " + p.getStockQuantity());
			System.out.println();
		}
	}
}

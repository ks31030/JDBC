package com.kh.MVC.dtoProduct;

import java.sql.Connection;
import java.util.List;

public class productController {
	private productModel model;
	private productView view; 
	public productController(Connection con, productView view) {
		this.model = new productModel(con);
		this.view = view;
	}
	public void displayAllProducts() {
		List<productDTO> products = model.getProducts();
		view.displayProducts(products);
	}
}

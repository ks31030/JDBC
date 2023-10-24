package com.kh.MVC.ProductsAdd;

import java.util.List;

public class ProductMain {

	public static void main(String[] args) {
		ProductDAO dao = new ProductDAO();
		ProductController controller = new ProductController(dao);
		ProductView view = new ProductView();
		//모든 제품 리스트 갖고 오기
		List<ProductDTO> products = controller.getAllProducts();
		view.showProductList(products);
		//최종가격 계산 갖고 오기
		double totalPrice = controller.calculateTotalPrice(products);
		view.showTotalPrice(totalPrice);
	}

}

package com.kh.MVC.Shopping;

import java.util.List;

public class ProductView {		/*제품 리스트 파라미터 추가*/
	public void showProductList(List<ProductDTO> products) {
		for(ProductDTO p : products) {
			System.out.println("제품명 : " + p.getProduct_name());
			System.out.println("가 격 : " + p.getPrice());
			System.out.println("==========================");
		}
	}
	public void showTotalPrice(double totalPrice) {
		System.out.println("총 액 : " + totalPrice);
	}
}

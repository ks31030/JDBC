package com.kh.MVC.ProductsAdd;

import java.util.List;

public class ProductView {		/*��ǰ ����Ʈ �Ķ���� �߰�*/
	public void showProductList(List<ProductDTO> products) {
		for(ProductDTO p : products) {
			System.out.println("ǰ �� : " + p.getProduct_id());
			System.out.println("��ǰ�� : " + p.getProduct_name());
			System.out.println("�� �� : " + p.getPrice());
			System.out.println("����� : " + p.getStock_quantity());
			System.out.println("==========================");
		}
	}
	public void showTotalPrice(double totalPrice) {
		System.out.println("�� �� : " + totalPrice);
	}
}
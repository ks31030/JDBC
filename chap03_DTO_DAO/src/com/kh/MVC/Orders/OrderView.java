package com.kh.MVC.Orders;

import java.util.List;

/*ORDER_ID
CAFE_ID
MENU_ID
ORDER_DATE
QUANTITY
TOTAL_PRICE*/ 
public class OrderView {
	public void showOrderList(List<OrderDTO> orders) {
		for(OrderDTO o : orders) {
			System.out.println("�ֹ���ȣ : " + o.getOrder_id());
			System.out.println("ī���ȣ : " + o.getCafe_id());
			System.out.println("�޴���ȣ : " + o.getMenu_id());
			System.out.println("�ֹ���¥ : " + o.getOrder_date());
			System.out.println("����� : " + o.getQuantity());
			System.out.println("�Ѿ� : " + o.getTotal_price());
		}
	}
	public void showTotalPrice(double totalPrice) {
		System.out.println("�Ѿ� : " + totalPrice);
	}
}
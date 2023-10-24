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
			System.out.println("주문번호 : " + o.getOrder_id());
			System.out.println("카페번호 : " + o.getCafe_id());
			System.out.println("메뉴번호 : " + o.getMenu_id());
			System.out.println("주문날짜 : " + o.getOrder_date());
			System.out.println("재고량 : " + o.getQuantity());
			System.out.println("총액 : " + o.getTotal_price());
		}
	}
	public void showTotalPrice(double totalPrice) {
		System.out.println("총액 : " + totalPrice);
	}
}

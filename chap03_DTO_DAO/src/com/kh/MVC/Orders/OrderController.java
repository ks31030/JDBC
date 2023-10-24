package com.kh.MVC.Orders;

import java.util.List;

public class OrderController {
	OrderDAO dao;
	public OrderController(OrderDAO dao) {
		this.dao = dao;
	}
	public double calculateTotalPrice(List<OrderDTO> orders) {
		double totalPrice = 0;
		for(OrderDTO totalP : orders) {
			totalPrice += totalP.getTotal_price();
		}
		return totalPrice;
	}
}	

package com.kh.MVC.Orders;

import java.util.List;


public class OrderMain {

	public static void main(String[] args, List<OrderDTO> orders) {
		OrderDAO dao = new OrderDAO();
		OrderController controller = new OrderController(dao);
		OrderView view = new OrderView();
		double totalPrice = controller.calculateTotalPrice(orders);
		view.showTotalPrice(totalPrice);

	}

}

package com.kh.MVC.Orders;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO {
	private Connection connection;
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String name = "KHCAFE";
	String pw = "KH1234";
	public OrderDAO() {
		try {
			connection = DriverManager.getConnection(url, name, pw);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public List<OrderDTO> getAllOrders(){
		List<OrderDTO> orders = new ArrayList<>();
		try {
			PreparedStatement st = connection.prepareStatement("SELECT * FROM orders");
			ResultSet result = st.executeQuery();
			while(result.next()) {
				int order_id = result.getInt("order_id");
				int cafe_id = result.getInt("cafe_id");
				int menu_id = result.getInt("menu_id");
				String order_date = result.getString("order_date");
				int quantity = result.getInt("quantity");
				double total_price  = result.getDouble("total_price");
				
				OrderDTO order = new OrderDTO(order_id, cafe_id, menu_id, order_date, quantity, total_price);
				orders.add(order);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orders;
	}
}

package com.kh.MVC.dtoProduct;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class productMain {

	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userName = "KHCAFE";
		String password = "KH1234";
		try {
			Connection connection = DriverManager.getConnection(url, userName, password);
			productView view = new productView();
			productController controller = new productController(connection, view);
			controller.displayAllProducts();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

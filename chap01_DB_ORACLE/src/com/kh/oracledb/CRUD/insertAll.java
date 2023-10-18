package com.kh.oracledb.CRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class insertAll {

	public static void main(String[] args) {
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String userName = "KHCAFE";
		String password = "KH1234";
		
		try {
			Connection con = DriverManager.getConnection(jdbcUrl, userName, password);
			String insertSQL = "INSERT INTO products(product_id, product_name, category, price, stock_quantity)" + "VALUES (?, ?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(insertSQL);
			//"products" 테이블에 데이터 삽입.
			insertProduct(ps, 7, "떡볶이코트", "의류", 499.99, 30);
			insertProduct(ps, 8, "김치냉장고", "가전제품", 1199.99, 10);
			insertProduct(ps, 9, "마우스", "전자제품", 79.99, 33);
			ps.close();//작성하지 않아도 정상적으로 실행되나 메모리를 많이 사용하기 때문에 닫음.
			int rowsInsert = ps.executeUpdate();
			System.out.println(rowsInsert + " row 추가됨.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	static void insertProduct(PreparedStatement ps, int product_id, String product_name, String category, double price, int stock_quantity) throws SQLException {
		ps.setInt(1, product_id);
		ps.setString(2, product_name);
		ps.setString(3, category);
		ps.setDouble(4, price);
		ps.setInt(5, stock_quantity);
		ps.executeUpdate();
	}
}

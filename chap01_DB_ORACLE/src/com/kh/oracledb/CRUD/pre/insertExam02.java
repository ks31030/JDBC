package com.kh.oracledb.CRUD.pre;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class insertExam02 {

	public static void main(String[] args) {
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String userName = "KHCAFE";
		String password = "KH1234";
		
		try {
			Connection con = DriverManager.getConnection(jdbcUrl, userName, password);
			String insertSQL = "INSERT INTO BOOK(book_id, title, author, publication_year, isbn, genre, description, price, publication_date, updated_date, is_available)" + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(insertSQL);
			insertbook(ps, 14, "피터팬", "제임스_M_베리", 1911, "978-654650", "Fantasy", "자라지 않는 장난꾸러기 소년", 33.99, Date.valueOf("1911-01-01"), Date.valueOf("2023-10-18"), "Y");
			insertbook(ps, 15, "어어그럼안되지", "원정연", 2020, "978-608808", "Fantasy", "그러면 진짜 안 됐을 이야기", 11.99, Date.valueOf("2021-01-01"), Date.valueOf("2023-10-16"), "Y");
			insertbook(ps, 16, "저한테왜그러세요", "안승애", 2019, "978-90904", "Novel", "진짜 왜 그러는지 모르겠음", 10.99, Date.valueOf("2020-01-01"), Date.valueOf("2023-10-15"), "Y");
			insertbook(ps, 17, "네가그런것아니니?", "김석", 2018, "978-316849", "Fantasy", "정말 내가 안 그랬는데", 12.99, Date.valueOf("2021-01-01"), Date.valueOf("2023-10-14"), "Y");
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	static void insertbook(PreparedStatement ps, int book_id, String title, String author, int publication_year, String isbn, String genre, String description, double price, Date publication_date, Date updated_date, String is_available) throws SQLException {
		ps.setInt(1, book_id);
		ps.setString(2, title);
		ps.setString(3, author);
		ps.setInt(4, publication_year);
		ps.setString(5, isbn);
		ps.setString(6, genre);
		ps.setString(7, description);
		ps.setDouble(8, price);
		ps.setDate(9, publication_date);
		ps.setDate(10, updated_date);
		ps.setString(11, is_available);
		int a = ps.executeUpdate();
	    	System.out.println(a);
	}
}

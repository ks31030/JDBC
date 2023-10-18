package com.kh.oracledb.CRUD;

import java.sql.Connection; //데이터베이스 작업 및 SQL 처리에 필요한 Java 클래스를 java.sql및 패키지에서 가져옵니다.
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class insertSample { // Java 클래스를 정의합니다.

	public static void main(String[] args) { //main프로그램을 실행할 때 메소드가 실행됩니다 .
		//insertBank();
		insertCafe();
	}
	
	static void insertBank() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "KHBANK";
		String password = "KH1234";
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			String insertQuery = "INSERT INTO BANK (account_id, account_number, account_name, balance, branch_name, last_transaction_date)"
								+ "VALUES(?, ?, ?, ?, ?, ?)";
			PreparedStatement insertState = con.prepareStatement(insertQuery);
			insertState.setInt(1, 13);
			insertState.setString(2, "9876351");
			insertState.setString(3, "안컴천");
			insertState.setInt(4, 2240);
			insertState.setString(5, "강남지점");
			insertState.setDate(6, Date.valueOf("2023-10-16"));
			
			int rowsInsert = insertState.executeUpdate();
			System.out.println(rowsInsert + " row 추가됨.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	static void insertCafe() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "KHCAFE";
		String password = "KH1234";
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			String insertQuery = "INSERT INTO CAFES (cafe_id, cname, address, phone_number, operating_hours)" + "VALUES(?, ?, ?, ?, ?)";
			PreparedStatement insertState = con.prepareStatement(insertQuery);
			insertState.setInt(1, 20);
			insertState.setString(2, "커피집");
			insertState.setString(3, "서울 서초구 서초동");
			insertState.setString(4, "02-2020-2020");
			insertState.setString(5, "월-금: 07:00-19:00");
			
			int rowsInsert = insertState.executeUpdate();
			System.out.println(rowsInsert + " row 추가됨.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

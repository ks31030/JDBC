package com.kh.oracledb.CRUD;

import java.sql.Connection; //�����ͺ��̽� �۾� �� SQL ó���� �ʿ��� Java Ŭ������ java.sql�� ��Ű������ �����ɴϴ�.
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class insertSample { // Java Ŭ������ �����մϴ�.

	public static void main(String[] args) { //main���α׷��� ������ �� �޼ҵ尡 ����˴ϴ� .
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
			insertState.setString(3, "����õ");
			insertState.setInt(4, 2240);
			insertState.setString(5, "��������");
			insertState.setDate(6, Date.valueOf("2023-10-16"));
			
			int rowsInsert = insertState.executeUpdate();
			System.out.println(rowsInsert + " row �߰���.");
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
			insertState.setString(2, "Ŀ����");
			insertState.setString(3, "���� ���ʱ� ���ʵ�");
			insertState.setString(4, "02-2020-2020");
			insertState.setString(5, "��-��: 07:00-19:00");
			
			int rowsInsert = insertState.executeUpdate();
			System.out.println(rowsInsert + " row �߰���.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
package com.kh.oracledb.CRUD;

import java.sql.Connection; //�����ͺ��̽� �۾� �� SQL ó���� �ʿ��� Java Ŭ������ java.sql�� ��Ű������ �����ɴϴ�.
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class selectSample { // Java Ŭ������ �����մϴ�.

	public static void main(String[] args) { //main���α׷��� ������ �� �޼ҵ尡 ����˴ϴ� .
		//selectAll();
		//selectKhcafe();
		//selectOne(); //���α׷��� ����� �� �ٸ� �޼��带 ȣ���մϴ�. �� ��� selectIf �޼��带 ȣ���մϴ�.
	}
	
	static void selectAll() { //���� �޼��带 �����մϴ�
		//1. ����̹� ���� : Oracle JDBC ����̹� Ŭ���� �̸�
		String driver = "oracle.jdbc.driver.OracleDriver";
		//2. ����Ŭ �� ��ǻ�� ���� : �����ͺ��̽� ��������
		//								����ip�ּ� : port��ȣ
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "KHBANK";
		String password = "KH1234";
		Connection con = null;
		
		try {
			//������ ����Ͽ� ���� ���� �Ǵ� �����ͺ��̽� �۾� ����.
			con = DriverManager.getConnection(url, user, password);
			System.out.println("�����ͺ��̽� ���� ����!");
			
			//SELECT ����
			String selectQuery = "SELECT * FROM BANK";
			PreparedStatement selectState = con.prepareStatement(selectQuery);
			ResultSet result = selectState.executeQuery();
			//result.next() : result ��ü���� ���� ��(row)���� �̵�.
			//���� ���� ������ true ��ȯ, �׷��� ������ false ��ȯ.
			while(result.next()) {
				//KHBANK�� �ִ� BANK ���̺� ������տ��� account-id�� ���� ��.
				int accountID = result.getInt("account_id");
				//1. �Բ� �غ��� : accountNumber
				double accountNumber = result.getDouble("account_number");
				String accountName = result.getString("account_name");
				double balance = result.getDouble("balance");
				//2. �Բ� �غ��� : branchName
				String branchName = result.getString("branch_name");
				//3. �Բ� �غ��� : java.sql import Date lastTransactionDate ��������
				Date lastTransactionDate = result.getDate("last_transaction_date");
				System.out.println("ACCOUNT_ID : " + accountID);
				System.out.println("ACCOUNT_NAME : " + accountName);
				System.out.println("BALANCE : " + balance);
				System.out.println("BRANCH_NAME : " + branchName);
				System.out.println("LAST_TRANSACTION_DATE : " + lastTransactionDate);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	static void selectKhcafe() {
		//1. ����̹� ���� : Oracle JDBC ����̹� Ŭ���� �̸�
		String driver = "oracle.jdbc.driver.OracleDriver";
		//2. ����Ŭ �� ��ǻ�� ���� : �����ͺ��̽� ��������
		//								����ip�ּ� : port��ȣ
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "KHCAFE";
		String password = "KH1234";
		Connection con = null;
		
		try {
			//������ ����Ͽ� ���� ���� �Ǵ� �����ͺ��̽� �۾� ����.
			con = DriverManager.getConnection(url, user, password);
			System.out.println("�����ͺ��̽� ���� ����!");
			
			//SELECT ����
			String selectQuery = "SELECT * FROM CAFES";
			PreparedStatement selectState = con.prepareStatement(selectQuery);
			ResultSet result = selectState.executeQuery();
			//result.next() : result ��ü���� ���� ��(row)���� �̵�.
			//���� ���� ������ true ��ȯ, �׷��� ������ false ��ȯ.
			while(result.next()) {
				//KHCAFE�� �ִ� CAFES ���̺� ������տ��� cafe-id�� ���� ��.
				int cafeID = result.getInt("cafe_id");
				String cafeName = result.getString("cname");
				String address = result.getString("address");
				String phoneNum = result.getString("phone_number");
				String oHours = result.getString("operating_hours");
				
				System.out.println("cafe_id : " + cafeID);
				System.out.println("cname : " + cafeName);
				System.out.println("address : " + address);
				System.out.println("phone_number : " + phoneNum);
				System.out.println("operating_hours : " + oHours);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	static void selectOne() {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "KHBANK";
		String password = "KH1234";
		Connection con = null;
		
		try {
			con = DriverManager.getConnection(url, user, password);
			String selectQuery = "SELECT * FROM BANK WHERE account_number in(?, ?)";
			PreparedStatement selectState = con.prepareStatement(selectQuery);
			
			String[] targetAN = {"1234567890", "5555666777"};
			selectState.setString(1, targetAN[0]);
			selectState.setString(2, targetAN[1]);
			
//			//���⿡ ���ϴ� ������ account_id ����.
//			int targetAID = 1;
//			//���� ����
//			selectState.setInt(1, targetAID);
			
			ResultSet result = selectState.executeQuery();
			
			if(result.next()) {
				int a = result.getInt("account_id");
				String b = result.getString("account_number");
				String c = result.getString("account_name");
				String d = result.getString("balance");
				String e = result.getString("branch_name");
				String f = result.getString("last_transaction_date");
				System.out.println("ACCOUNT_ID : " + a);
				System.out.println("ACCOUNT_NUMBER : " + b);
				System.out.println("ACCOUNT_NAME : " + c);
				System.out.println("BALANCE : " + d);
				System.out.println("BRANCH_NAME : " + e);
				System.out.println("LAST_TRANSACTION_DATE : " + f);
			} else {
				System.out.println("���ǿ� �ش��ϴ� �����Ͱ� �����ϴ�.");
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
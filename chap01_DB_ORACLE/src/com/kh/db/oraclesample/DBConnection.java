package com.kh.db.oraclesample;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {

	public static void main(String[] args) {
		//selectBank();
		selectKhcafe();
	}
	
	static void selectBank() {
		//1. 드라이버 연결 : Oracle JDBC 드라이버 클래스 이름
		String driver = "oracle.jdbc.driver.OracleDriver";
		//2. 오라클 내 컴퓨터 연결 : 데이터베이스 연결정보
		//								나의ip주소 : port번호
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "KHBANK";
		String password = "KH1234";
		Connection con = null;
		try {
			//연결을 사용하여 쿼리 실행 또는 데이터베이스 작업 수행.
			con = DriverManager.getConnection(url, user, password);
			System.out.println("데이터베이스 연결 성공!");
			
			//SELECT 쿼리
			String selectQuery = "SELECT * FROM BANK";
			PreparedStatement selectState = con.prepareStatement(selectQuery);
			ResultSet result = selectState.executeQuery();
			//result.next() : result 객체에서 다음 행(row)으로 이동.
			//다음 행이 있으면 true 반환, 그렇지 않으면 false 반환.
			while(result.next()) {
				//KHBANK에 있는 BANK 테이블 결과집합에서 account-id를 가져 옴.
				int accountID = result.getInt("account_id");
				//1. 함께 해보기 : accountNumber
				double accountNumber = result.getDouble("account_number");
				String accountName = result.getString("account_name");
				double balance = result.getDouble("balance");
				//2. 함께 해보기 : branchName
				String branchName = result.getString("branch_name");
				//3. 함께 해보기 : java.sql import Date lastTransactionDate 가져오기
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
		//1. 드라이버 연결 : Oracle JDBC 드라이버 클래스 이름
		String driver = "oracle.jdbc.driver.OracleDriver";
		//2. 오라클 내 컴퓨터 연결 : 데이터베이스 연결정보
		//								나의ip주소 : port번호
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "KHCAFE";
		String password = "KH1234";
		Connection con = null;
		try {
			//연결을 사용하여 쿼리 실행 또는 데이터베이스 작업 수행.
			con = DriverManager.getConnection(url, user, password);
			System.out.println("데이터베이스 연결 성공!");
			
			//SELECT 쿼리
			String selectQuery = "SELECT * FROM CAFES";
			PreparedStatement selectState = con.prepareStatement(selectQuery);
			ResultSet result = selectState.executeQuery();
			//result.next() : result 객체에서 다음 행(row)으로 이동.
			//다음 행이 있으면 true 반환, 그렇지 않으면 false 반환.
			while(result.next()) {
				//KHCAFE에 있는 CAFES 테이블 결과집합에서 cafe-id를 가져 옴.
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
}

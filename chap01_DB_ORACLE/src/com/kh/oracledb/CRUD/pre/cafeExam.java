package com.kh.oracledb.CRUD.pre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//6. 특정 카페의 정보 삭제하기
//9. 특정 메뉴 정보 가져오기
//10. 모든 카페의 이름과 주소 가져오기
//11. 특정 카페의 운영시간 변경 및 결과 확인
//12. 특정 카페의 전화번호 변경 및 결과 확인
public class cafeExam {

	public static void main(String[] args) {
//		allList();
//		oneMenu();
//		newCafe();
//		insertCafe();
//		updatePrice();
//		updateInfo();
//		selectMenuCount();
		specificMenu();
	}
	//1. 모든 카페 목록 가져오기
	static void allList() {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "KHCAFE";
		String password = "KH1234";
		
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("데이터베이스 연결 성공!");
			String selectQuery = "SELECT * FROM CAFES";
			PreparedStatement selectState = con.prepareStatement(selectQuery);
			ResultSet result = selectState.executeQuery();
			while(result.next()) {
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
	//2. 특정 카페의 메뉴 가져오기
	static void oneMenu() {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "KHCAFE";
		String password = "KH1234";
		
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("데이터베이스 연결 성공!");
			String selectQuery = "SELECT * FROM MENU WHERE CAFE_ID = ?";
			PreparedStatement selectState = con.prepareStatement(selectQuery);
			selectState.setInt(1, 1);
			ResultSet result = selectState.executeQuery();
			while(result.next()) {
				String menuName = result.getString("menu_name");
				System.out.println("menu_name : " + menuName);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//3. 새로운 카페 추가하기
	static void newCafe() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "KHCAFE";
		String password = "KH1234";
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("데이터베이스 연결 성공!");
			String insertSQL = "INSERT INTO CAFES (cafe_id, cname, address, phone_number, operating_hours)" + "VALUES(?, ?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(insertSQL);
			insertCafe(ps, 27, "기성용카페", "일본 도쿄", "02-4531-8060", "매일: 04:00-22:00");
			int rowsInsert = ps.executeUpdate();
			System.out.println(rowsInsert + " row 추가됨.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	static void insertCafe(PreparedStatement ps, int cafe_id, String cname, String address, String phone_number, String operating_hours) throws SQLException {
		ps.setInt(1, cafe_id);
		ps.setString(2, cname);
		ps.setString(3, address);
		ps.setString(4, phone_number);
		ps.setString(5, operating_hours);
		ps.executeUpdate();
	}
	//4. 특정 카페의 메뉴 가격 변경
	static void updatePrice() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "KHCAFE";
		String password = "KH1234";
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("데이터베이스 연결 성공!");
			String updateQuery = "UPDATE MENU SET PRICE = ? WHERE CAFE_ID = ?";
			PreparedStatement updatePs = con.prepareStatement(updateQuery);
			updatePs.setDouble(1, 199.99);
			updatePs.setInt(2, 1);
			int rowsUpdate = updatePs.executeUpdate();
			System.out.println(rowsUpdate + " 업데이트 되었습니다.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//5. 특정 카페의 정보 수정하기
	static void updateInfo() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "KHCAFE";
		String password = "KH1234";
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("데이터베이스 연결 성공");
			String updateQuery = "UPDATE CAFES SET CNAME = ? WHERE CAFE_ID = 1";
			PreparedStatement updatePs = con.prepareStatement(updateQuery);
			updatePs.setString(1, "별거아닌카페");
			int rowsUpdate = updatePs.executeUpdate();
			System.out.println(rowsUpdate + " 업데이트 되었습니다.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//7. 특정 카페의 메뉴 수 가져오기
	static void selectMenuCount() {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "KHCAFE";
		String password = "KH1234";
		
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("데이터베이스 연결 성공!");
			String selectQuery = "SELECT COUNT(*) AS MENU_ID FROM MENU WHERE CAFE_ID = ?";
			PreparedStatement selectState = con.prepareStatement(selectQuery);
			selectState.setInt(1,1);
			ResultSet result = selectState.executeQuery();
			while(result.next()) {
				String menuCount = result.getString("MENU_ID");
				System.out.println("메뉴 갯수 : " + menuCount);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//8. 특정 가격 범위 내의 모든 메뉴 가져오기
	static void specificMenu() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "KHCAFE";
		String password = "KH1234";
		
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("데이터베이스 연결 성공!");
			String selectQuery = "SELECT * FROM MENU WHERE PRICE BETWEEN ? AND ?";
			PreparedStatement selectState = con.prepareStatement(selectQuery);
			selectState.setInt(1, 100);
			selectState.setInt(2, 200);
			ResultSet result = selectState.executeQuery();
			while(result.next()) {
				String menuName = result.getString("menu_name");
				System.out.println("menu_name : " + menuName);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

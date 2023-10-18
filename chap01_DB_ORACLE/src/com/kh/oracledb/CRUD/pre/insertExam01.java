package com.kh.oracledb.CRUD.pre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//CAFES insert 작성해서 여러 카페 추가하기
public class insertExam01 {

	public static void main(String[] args) {
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String userName = "KHCAFE";
		String password = "KH1234";

		try {
			Connection con = DriverManager.getConnection(jdbcUrl, userName, password);
			String insertSQL = "INSERT INTO CAFES (cafe_id, cname, address, phone_number, operating_hours)" + "VALUES(?, ?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(insertSQL);//SQL문에 연결하여 INSERT해주기 위한 준비완료.
			insertCafe(ps, 24, "박지성카페", "영국 리버풀시", "66-131-5313", "매일: 06:00-22:00");
			insertCafe(ps, 25, "즐라탄커피", "서울 양천구", "02-605-4615", "월-금: 10:00-18:00");
			insertCafe(ps, 26, "박주영커피", "브라질 상파울루시", "33-794-1545", "매일: 07:00-15:00");
//			ps.close();
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
}

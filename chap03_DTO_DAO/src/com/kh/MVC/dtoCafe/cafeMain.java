package com.kh.MVC.dtoCafe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class cafeMain {

	public static void main(String[] args) {
		//Connection에 연결할 내용 작성.
		//url userName password
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userName = "KHCAFE";
		String password = "KH1234";
		try {
			Connection con = DriverManager.getConnection(url, userName, password);
			//인스턴스 생성하여 뷰 초기화.
			cafeView view = new cafeView();
			//인스턴스 생성하여 컨트롤러 초기화.
			cafeController controller = new cafeController(con, view);
			//카페 정보 표시하는 메서드
			controller.displayAllCafes();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

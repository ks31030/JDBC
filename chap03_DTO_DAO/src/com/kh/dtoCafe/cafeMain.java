package com.kh.dtoCafe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class cafeMain {

	public static void main(String[] args) {
		//Connection�� ������ ���� �ۼ�.
		//url userName password
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userName = "KHCAFE";
		String password = "KH1234";
		try {
			Connection con = DriverManager.getConnection(url, userName, password);
			//�ν��Ͻ� �����Ͽ� �� �ʱ�ȭ.
			cafeView view = new cafeView();
			//�ν��Ͻ� �����Ͽ� ��Ʈ�ѷ� �ʱ�ȭ.
			cafeController controller = new cafeController(con, view);
			//ī�� ���� ǥ���ϴ� �޼���
			controller.displayAllCafes();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
package com.kh.oracledb.CRUD.pre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//CAFES insert �ۼ��ؼ� ���� ī�� �߰��ϱ�
public class insertExam01 {

	public static void main(String[] args) {
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String userName = "KHCAFE";
		String password = "KH1234";

		try {
			Connection con = DriverManager.getConnection(jdbcUrl, userName, password);
			String insertSQL = "INSERT INTO CAFES (cafe_id, cname, address, phone_number, operating_hours)" + "VALUES(?, ?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(insertSQL);//SQL���� �����Ͽ� INSERT���ֱ� ���� �غ�Ϸ�.
			insertCafe(ps, 24, "������ī��", "���� ����Ǯ��", "66-131-5313", "����: 06:00-22:00");
			insertCafe(ps, 25, "���źĿ��", "���� ��õ��", "02-605-4615", "��-��: 10:00-18:00");
			insertCafe(ps, 26, "���ֿ�Ŀ��", "����� ���Ŀ���", "33-794-1545", "����: 07:00-15:00");
//			ps.close();
			int rowsInsert = ps.executeUpdate();
			System.out.println(rowsInsert + " row �߰���.");
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
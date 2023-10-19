package cafe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class cafeModel {
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String userName = "KHCAFE";
	String password = "KH1234";
	public void insertCafe(String name, String address, String phone_number, String operating_hours) {
		try {
			Connection con = DriverManager.getConnection(url, userName, password);
			System.out.println("데이터베이스 연결 성공!");
			String sql = "INSERT INTO CAFES(name, address, phone_number, operating_hours)" + "VALUES(?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, address);
			ps.setString(3, phone_number);
			ps.setString(4, operating_hours);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void updateCafe(String operating_hours, int cafe_id) {
		try {
			Connection con = DriverManager.getConnection(url, userName, password);
			String sql = "UPDATE CAFES SET OPERATING_HOURS = ? WHERE CAFE_ID = ?";
			PreparedStatement pp = con.prepareStatement(sql);
			pp.setString(1, operating_hours);
			pp.setInt(2, cafe_id);
			pp.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void updateMenu(String description, int menu_id, int cafe_id) {
		try {
			Connection con = DriverManager.getConnection(url, userName, password);
			String sql = "UPDATE MENU SET DESCRIPTION = ? WHERE MENU_ID = ? AND CAFE_ID = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, description);
			st.setInt(2, menu_id);
			st.setInt(3, cafe_id);
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void deleteCafe(int cafe_id) {
		try {
			Connection con = DriverManager.getConnection(url, userName, password);
			String sql = "DELETE FROM CAFES WHERE CAFE_ID = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, cafe_id);
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void deleteMenu(int menu_id) {
		try {
			Connection con = DriverManager.getConnection(url, userName, password);
			String sql = "DELETE FROM MENU WHERE MENU_ID = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, menu_id);
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void insertMenu(int menu_id, int cafe_id, String menu_name, double price, String description) {
		try {
			Connection con = DriverManager.getConnection(url, userName, password);
			System.out.println("데이터베이스 연결 성공!");
			String sql = "INSERT INTO MENU(MENU_ID, CAFE_ID, MENU_NAME, PRICE, DESCRIPTION)" + "VALUES(?, ?, ?, ?, ?)";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, menu_id);
			st.setInt(2, cafe_id);
			st.setString(3, menu_name);
			st.setDouble(4, price);
			st.setString(5, description);
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

package com.kh.oracledb.CRUD.pre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//6. Ư�� ī���� ���� �����ϱ�
//9. Ư�� �޴� ���� ��������
//10. ��� ī���� �̸��� �ּ� ��������
//11. Ư�� ī���� ��ð� ���� �� ��� Ȯ��
//12. Ư�� ī���� ��ȭ��ȣ ���� �� ��� Ȯ��
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
	//1. ��� ī�� ��� ��������
	static void allList() {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "KHCAFE";
		String password = "KH1234";
		
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("�����ͺ��̽� ���� ����!");
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
	//2. Ư�� ī���� �޴� ��������
	static void oneMenu() {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "KHCAFE";
		String password = "KH1234";
		
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("�����ͺ��̽� ���� ����!");
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
	//3. ���ο� ī�� �߰��ϱ�
	static void newCafe() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "KHCAFE";
		String password = "KH1234";
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("�����ͺ��̽� ���� ����!");
			String insertSQL = "INSERT INTO CAFES (cafe_id, cname, address, phone_number, operating_hours)" + "VALUES(?, ?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(insertSQL);
			insertCafe(ps, 27, "�⼺��ī��", "�Ϻ� ����", "02-4531-8060", "����: 04:00-22:00");
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
	//4. Ư�� ī���� �޴� ���� ����
	static void updatePrice() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "KHCAFE";
		String password = "KH1234";
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("�����ͺ��̽� ���� ����!");
			String updateQuery = "UPDATE MENU SET PRICE = ? WHERE CAFE_ID = ?";
			PreparedStatement updatePs = con.prepareStatement(updateQuery);
			updatePs.setDouble(1, 199.99);
			updatePs.setInt(2, 1);
			int rowsUpdate = updatePs.executeUpdate();
			System.out.println(rowsUpdate + " ������Ʈ �Ǿ����ϴ�.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//5. Ư�� ī���� ���� �����ϱ�
	static void updateInfo() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "KHCAFE";
		String password = "KH1234";
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("�����ͺ��̽� ���� ����");
			String updateQuery = "UPDATE CAFES SET CNAME = ? WHERE CAFE_ID = 1";
			PreparedStatement updatePs = con.prepareStatement(updateQuery);
			updatePs.setString(1, "���žƴ�ī��");
			int rowsUpdate = updatePs.executeUpdate();
			System.out.println(rowsUpdate + " ������Ʈ �Ǿ����ϴ�.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//7. Ư�� ī���� �޴� �� ��������
	static void selectMenuCount() {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "KHCAFE";
		String password = "KH1234";
		
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("�����ͺ��̽� ���� ����!");
			String selectQuery = "SELECT COUNT(*) AS MENU_ID FROM MENU WHERE CAFE_ID = ?";
			PreparedStatement selectState = con.prepareStatement(selectQuery);
			selectState.setInt(1,1);
			ResultSet result = selectState.executeQuery();
			while(result.next()) {
				String menuCount = result.getString("MENU_ID");
				System.out.println("�޴� ���� : " + menuCount);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//8. Ư�� ���� ���� ���� ��� �޴� ��������
	static void specificMenu() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "KHCAFE";
		String password = "KH1234";
		
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("�����ͺ��̽� ���� ����!");
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
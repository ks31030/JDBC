package com.kh.db.oraclesample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {

	public static void main(String[] args) {
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
				String accountName = result.getString("account_name");
				double balance = result.getDouble("balance");
				//2. �Բ� �غ��� : branchName
				//java.sql import Date lastTransactionDate ��������
				System.out.println("ACCOUNT_ID : " + accountID + " ACCOUNT_NAME : " + accountName + " BALANCE : " + balance);
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
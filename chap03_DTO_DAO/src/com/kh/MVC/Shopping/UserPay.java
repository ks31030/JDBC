package com.kh.MVC.Shopping;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserPay {
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String userName = "KHBANK";
	String password = "KH1234";
	
	ShoppingCart cart;
	public UserPay(ShoppingCart cart) {
		this.cart = cart;
	}
	public boolean payment() {
		Connection connection = null;
		double cartTotalPrice = cart.cartTotalPrice();/*카트 안에 최종 결제 금액 메서드 추가하기*/
		try {
			connection = DriverManager.getConnection(url, userName, password);
			//가나다 씨의 계좌 잔액 가져 오기
			String userBalance = "SELECT balance FROM BANK WHERE account_name = '가나다'";
			PreparedStatement st = connection.prepareCall(userBalance);
			ResultSet rs = st.executeQuery();//executeQuery는 주로 SELECT에 사용. executeUpdate는 INSERT에 사용.
			if(rs.next()) {
				double balance = rs.getDouble("balance");
				//만약에 잔액이 장바구니 총액보다 적다면?
				if(balance < cartTotalPrice) {
					System.out.println("잔액이 부족합니다.");
					return false;
				}
				//내가 갖고 있는 잔액에서 장바구니 총액을 빼주어야 함.
				double newBalance = balance - cartTotalPrice;
				//잔액 업데이트하기
				String updateBalance = "UPDATE BANK SET balance = ? WHERE account_name = '가나다'";
				PreparedStatement upSt = connection.prepareStatement(updateBalance);
				upSt.setDouble(1, newBalance);
				upSt.executeUpdate();
				System.out.println("결제완료! 잔액 : " + newBalance);
				return true;
			} else {
				System.out.println("계좌를 찾을 수 없습니다.");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}

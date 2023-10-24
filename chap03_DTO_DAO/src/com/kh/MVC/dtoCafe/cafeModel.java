package com.kh.MVC.dtoCafe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class cafeModel {
	private Connection con;
	
	public cafeModel(Connection con) {
		this.con = con;
	}
	public List<cafeDTO> getCafes() {
		List<cafeDTO> cafes = new ArrayList<>();
		String query = "SELECT * FROM CAFES";
		try {
			PreparedStatement st = con.prepareStatement(query);
			ResultSet result = st.executeQuery();
			while(result.next()) {
				//������ ���� ����� ����Ͽ� �־� �� ���� �ۼ�����(ex. int cafeId = result.getInt("cafe_id")).
				//������ DTO�� Ȱ���Ͽ� ���� ����� ĸ��ȭ(��ȣ, private)�Ͽ� ���� DTO�� �ۼ����ش�.
				//�׸��� DTO�� �ۼ��� ��ü�� �ν��Ͻ�ȭ�Ͽ� ��ü �ȿ� �ִ� ��� ������ ȣ���Ѵ�.
				cafeDTO cafe = new cafeDTO();
				cafe.setCafeId(result.getInt("cafe_id"));
				cafe.setCafeName(result.getString("name"));
				cafe.setAddress(result.getString("address"));
				cafe.setPhoneNumber(result.getString("phone_number"));
				cafe.setOperatingHours(result.getString("operating_hours"));
				cafes.add(cafe);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cafes;
	}
}
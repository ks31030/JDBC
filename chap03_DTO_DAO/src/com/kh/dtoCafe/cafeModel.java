package com.kh.dtoCafe;

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
				//기존에 예약어나 참조어를 사용하여 넣어 줄 값을 작성했음(ex. int cafeId = result.getInt("cafe_id")).
				//이제는 DTO를 활용하여 예약어나 참조어를 캡슐화(보호, private)하여 따로 DTO로 작성해준다.
				//그리고 DTO로 작성한 객체를 인스턴스화하여 객체 안에 있는 멤버 변수를 호출한다.
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

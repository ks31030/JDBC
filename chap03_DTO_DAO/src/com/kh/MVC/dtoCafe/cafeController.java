package com.kh.MVC.dtoCafe;

import java.sql.Connection;
import java.util.List;

//model과 view를 연결하는 중간 다리.
public class cafeController {
	//필드
	private cafeModel model; //모델 멤버변수
	private cafeView view; //뷰 멤버변수
	//파라미터 작성한 생성자
	public cafeController(Connection con, cafeView view) {
		this.model = new cafeModel(con);
		this.view = view;
	}
	//출력 메서드
	public void displayAllCafes() {
		List<cafeDTO> cafes = model.getCafes();
		view.displayCafes(cafes);
	}
}

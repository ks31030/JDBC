package com.kh.MVC.dtoCafe;

import java.sql.Connection;
import java.util.List;

//model�� view�� �����ϴ� �߰� �ٸ�.
public class cafeController {
	//�ʵ�
	private cafeModel model; //�� �������
	private cafeView view; //�� �������
	//�Ķ���� �ۼ��� ������
	public cafeController(Connection con, cafeView view) {
		this.model = new cafeModel(con);
		this.view = view;
	}
	//��� �޼���
	public void displayAllCafes() {
		List<cafeDTO> cafes = model.getCafes();
		view.displayCafes(cafes);
	}
}
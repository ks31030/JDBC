package com.kh.dtoCafe;

import java.util.List;

public class cafeView {
	//view���� �ַ� void �޼��带 ����Ѵ�.
	public void displayCafes(List<cafeDTO> cafes) {
		for(cafeDTO c : cafes) {
			System.out.println("Cafe ID : " + c.getCafeId());
			System.out.println("Cafe Name : " + c.getCafeName());
			System.out.println("Address : " + c.getAddress());
			System.out.println("Phone Number : " + c.getPhoneNumber());
			System.out.println("Operating Hours : " + c.getOperatingHours());
			System.out.println();
		}
	}
}
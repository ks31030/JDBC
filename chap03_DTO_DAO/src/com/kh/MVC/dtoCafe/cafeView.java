package com.kh.MVC.dtoCafe;

import java.util.List;

public class cafeView {
	//view에는 주로 void 메서드를 사용한다.
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

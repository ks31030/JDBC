package com.kh.mvcCafe;

import java.util.Scanner;

public class cafeController {
	public cafeModel model;
	public cafeView view;
	//모델과 뷰를 가져 올 생성자.
	public cafeController(cafeModel model, cafeView view) {
		this.model = model;
		this.view = view;
	}
	//run
	public void run() {
		boolean isTrue = true;
		
		while(isTrue) {
			Scanner sc = new Scanner(System.in);
			//선택할 번호 출력 메서드로 입력.
			System.out.println("1. 카페 정보 추가");
			System.out.println("2. 메뉴 설명 추가");
			System.out.println("3. 카페 운영시간 변경");
			System.out.println("4. 카페 삭제");
			System.out.println("5. 메뉴 삭제");
			System.out.println("6. 메뉴 추가");
			System.out.println("7. 종료");
			System.out.println("원하는 작업을 선택해주세요.");
			int choice = sc.nextInt();
		if(choice == 1) {
			view.addCafeName();
			break;
		} else if(choice == 2) {
			view.updateMenu();
			break;
		} else if(choice == 3) {
			view.updateCafe();
			break;
		} else if(choice == 4) {
			view.deleteCafe();
			break;
		} else if(choice == 5) {
			view.deleteMenu();
			break;
		} else if(choice == 6) {
			view.insertMenu();
			break;
		} else if(choice == 7) {
			System.out.println("프로그램을 종료합니다.");
			isTrue = false;
		} else {
			System.out.println("잘못된 번호입니다. 올바른 번호를 입력하세요!");
		  }
		}
	}
}

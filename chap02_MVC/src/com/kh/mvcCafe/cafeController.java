package com.kh.mvcCafe;

import java.util.Scanner;

public class cafeController {
	public cafeModel model;
	public cafeView view;
	//�𵨰� �並 ���� �� ������.
	public cafeController(cafeModel model, cafeView view) {
		this.model = model;
		this.view = view;
	}
	//run
	public void run() {
		boolean isTrue = true;
		
		while(isTrue) {
			Scanner sc = new Scanner(System.in);
			//������ ��ȣ ��� �޼���� �Է�.
			System.out.println("1. ī�� ���� �߰�");
			System.out.println("2. �޴� ���� �߰�");
			System.out.println("3. ī�� ��ð� ����");
			System.out.println("4. ī�� ����");
			System.out.println("5. �޴� ����");
			System.out.println("6. �޴� �߰�");
			System.out.println("7. ����");
			System.out.println("���ϴ� �۾��� �������ּ���.");
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
			System.out.println("���α׷��� �����մϴ�.");
			isTrue = false;
		} else {
			System.out.println("�߸��� ��ȣ�Դϴ�. �ùٸ� ��ȣ�� �Է��ϼ���!");
		  }
		}
	}
}
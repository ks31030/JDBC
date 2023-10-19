package cafe;

import java.util.Scanner;

public class cafeView {
	//cafeModel 이라는 클래스를 갖고 오기 위해 멤버변수로 카페모델을 추가함.
	public cafeModel model;
	//model 매개변수를 받을 수 있는 생성자를 만들어 주어야 함.
	public cafeView(cafeModel model) {
		this.model = model;
	}
	//cname, address, phone_number, operating_hours
	public void addCafeName() {
		Scanner sc = new Scanner(System.in);
		System.out.println("카페 정보를 입력하세요.");
		System.out.print("상호명 : ");
		String cname = sc.nextLine();
		System.out.print("주소 : ");
		String address = sc.nextLine();
		System.out.print("전화번호 : ");
		String phone_number = sc.nextLine();
		System.out.print("운영시간 : ");
		String operating_hours = sc.nextLine();
		//카페 모델에서 insertCafe 라는 메서드를 가지고 와야 함.
		model.insertCafe(cname, address, phone_number, operating_hours);
		System.out.println("카페가 성공적으로 추가되었습니다.");
	}
	public void updateCafe() {
		Scanner sc = new Scanner(System.in);
		System.out.println("카페 정보를 업데이트하세요.");
		System.out.print("운영시간 : ");
		String operating_hours = sc.nextLine();
		System.out.print("카페ID : ");
		int cafe_id = sc.nextInt();
		model.updateCafe(operating_hours, cafe_id);
		System.out.println("카페 정보가 업데이트되었습니다.");
	}
	public void updateMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("메뉴 설명을 업데이트하세요.");
		System.out.print("메뉴설명 : ");
		String description = sc.nextLine();
		System.out.print("메뉴ID : ");
		int menu_id = sc.nextInt();
		System.out.print("카페ID : ");
		int cafe_id = sc.nextInt();
		model.updateMenu(description, cafe_id, menu_id);
		System.out.println("메뉴 설명이 업데이트되었습니다.");
	}
	public void deleteCafe() {
		Scanner sc = new Scanner(System.in);
		System.out.println("카페를 삭제할게요.");
		System.out.print("삭제요망 카페ID : ");
		int cafe_id = Integer.parseInt(sc.nextLine());//int를 문자로 입력하고자 할 때.
		model.deleteCafe(cafe_id);
		System.out.println("카페가 삭제되었습니다.");
	}
	public void deleteMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("메뉴를 삭제할게요.");
		System.out.print("삭제요망 메뉴ID : ");
		int menu_id = Integer.parseInt(sc.nextLine());
		model.deleteMenu(menu_id);
		System.out.println("메뉴가 삭제되었습니다.");
	}
	public void insertMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("메뉴를 추가합니다.");
		System.out.print("메뉴ID : ");
		int menu_id = sc.nextInt();
		System.out.print("카페ID : ");
		int cafe_id = sc.nextInt();
		System.out.print("메뉴명 : ");
		String menu_name = sc.next();
		System.out.print("가격 : ");
		double price = sc.nextDouble();
		System.out.print("설명 : ");
		String description = sc.nextLine();
		model.insertMenu(menu_id, cafe_id, menu_name, price, description);
		System.out.println("메뉴가 성공적으로 추가되었습니다.");
	}
}

package cafe;

import java.util.Scanner;

public class cafeView {
	//cafeModel �̶�� Ŭ������ ���� ���� ���� ��������� ī����� �߰���.
	public cafeModel model;
	//model �Ű������� ���� �� �ִ� �����ڸ� ����� �־�� ��.
	public cafeView(cafeModel model) {
		this.model = model;
	}
	//cname, address, phone_number, operating_hours
	public void addCafeName() {
		Scanner sc = new Scanner(System.in);
		System.out.println("ī�� ������ �Է��ϼ���.");
		System.out.print("��ȣ�� : ");
		String cname = sc.nextLine();
		System.out.print("�ּ� : ");
		String address = sc.nextLine();
		System.out.print("��ȭ��ȣ : ");
		String phone_number = sc.nextLine();
		System.out.print("��ð� : ");
		String operating_hours = sc.nextLine();
		//ī�� �𵨿��� insertCafe ��� �޼��带 ������ �;� ��.
		model.insertCafe(cname, address, phone_number, operating_hours);
		System.out.println("ī�䰡 ���������� �߰��Ǿ����ϴ�.");
	}
	public void updateCafe() {
		Scanner sc = new Scanner(System.in);
		System.out.println("ī�� ������ ������Ʈ�ϼ���.");
		System.out.print("��ð� : ");
		String operating_hours = sc.nextLine();
		System.out.print("ī��ID : ");
		int cafe_id = sc.nextInt();
		model.updateCafe(operating_hours, cafe_id);
		System.out.println("ī�� ������ ������Ʈ�Ǿ����ϴ�.");
	}
	public void updateMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("�޴� ������ ������Ʈ�ϼ���.");
		System.out.print("�޴����� : ");
		String description = sc.nextLine();
		System.out.print("�޴�ID : ");
		int menu_id = sc.nextInt();
		System.out.print("ī��ID : ");
		int cafe_id = sc.nextInt();
		model.updateMenu(description, cafe_id, menu_id);
		System.out.println("�޴� ������ ������Ʈ�Ǿ����ϴ�.");
	}
	public void deleteCafe() {
		Scanner sc = new Scanner(System.in);
		System.out.println("ī�並 �����ҰԿ�.");
		System.out.print("������� ī��ID : ");
		int cafe_id = Integer.parseInt(sc.nextLine());//int�� ���ڷ� �Է��ϰ��� �� ��.
		model.deleteCafe(cafe_id);
		System.out.println("ī�䰡 �����Ǿ����ϴ�.");
	}
	public void deleteMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("�޴��� �����ҰԿ�.");
		System.out.print("������� �޴�ID : ");
		int menu_id = Integer.parseInt(sc.nextLine());
		model.deleteMenu(menu_id);
		System.out.println("�޴��� �����Ǿ����ϴ�.");
	}
	public void insertMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("�޴��� �߰��մϴ�.");
		System.out.print("�޴�ID : ");
		int menu_id = sc.nextInt();
		System.out.print("ī��ID : ");
		int cafe_id = sc.nextInt();
		System.out.print("�޴��� : ");
		String menu_name = sc.next();
		System.out.print("���� : ");
		double price = sc.nextDouble();
		System.out.print("���� : ");
		String description = sc.nextLine();
		model.insertMenu(menu_id, cafe_id, menu_name, price, description);
		System.out.println("�޴��� ���������� �߰��Ǿ����ϴ�.");
	}
}
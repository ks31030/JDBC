package com.kh.MVC.Shopping;

import java.util.List;
import java.util.Scanner;

public class ProductMain {

	public static void main(String[] args) {
		ProductDAO dao = new ProductDAO();
		ProductController controller = new ProductController(dao);
		ProductView view = new ProductView();
		
		List<ProductDTO> products = controller.getAllProducts();
		System.out.println("���ϴ� �׸��� �����ϼ���.");
		System.out.println("1. ��� ��ǰ ����Ʈ");
		System.out.println("2. ���� ����");
		System.out.println("3. ��ǰ �߰�");
		System.out.println("4. ��ǰ ����");
		Scanner sc = new Scanner(System.in);
		//����ī�� �ν��Ͻ� �����ڸ�
		ShoppingCart cart = new ShoppingCart();
		int choice = sc.nextInt();
		switch(choice) {
			case 1 :
				//��� ��ǰ ����Ʈ ���� ����
				view.showProductList(products);
			case 2 :
				//�������� ��� ���� ����
				double totalPrice = controller.calculateTotalPrice(products);
				view.showTotalPrice(totalPrice);
			case 3 :
				//��ǰ �߰�
				System.out.println("��ٱ��Ͽ� �߰��� ��ǰ�� ID�� �Է��ϼ���. : ");
				//��ǰ ID �Է� �ޱ�
				int productId = sc.nextInt();
				//���� for���� if���� Ȱ���ؼ� ��ǰ ���
				for(ProductDTO p : products) {
					if(p.getProduct_id() == productId) {
						//īƮ�� �߰�
						cart.addCart(p);
						System.out.println(p.getProduct_name() + "��(��) ��ٱ��Ͽ� ��ҽ��ϴ�.");
						break;
					}
				}
			case 4 :
				//����
				System.out.println("��ٱ��Ͽ��� ������ ��ǰ�� ID�� �Է��ϼ���. : ");
				int removeProductId = sc.nextInt();
				for(ProductDTO r : cart.getCartList()) {
					if(r.getProduct_id() == removeProductId) {
						cart.removeGoods(r);
						break;
					}
				}
			case 5 :
				//����
				UserPay pay = new UserPay(cart);
				boolean payResult = pay.payment();
				if(payResult) {
					//īƮ ���� cart
				}
				break;
			default :
				System.out.println("�߸��� �����Դϴ�.");
		}		
	}

}
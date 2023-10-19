package cafe;

public class cafeMain {
	
	public static void main(String[] args) {
		cafeModel model = new cafeModel();
		cafeView view = new cafeView(model);
		//controller
		cafeController controller = new cafeController(model, view);
		controller.run();
//		view.addCafeName();
//		view.updateMenu();
//		view.updateCafe();
//		view.deleteCafe();
//		view.deleteMenu();
//		view.insertMenu();
	}
}
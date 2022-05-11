

import controller.OrderHandlingController;
import data.DaoFactory;
import data.OrderDao;
import data.ProductDao;
import gui.MainWindow;

public class Program {

	public static void main(String args[]) {

		OrderDao orderDao = DaoFactory.createOrderDao();
		ProductDao productDao = DaoFactory.createProductDao();
		
		OrderHandlingController orderHandlingController = new OrderHandlingController(orderDao, productDao);		
		
		MainWindow main;
		
		try {
			
			main = new MainWindow(orderHandlingController);
			main.setVisible(true);	
			
		} catch (Exception e) {
			e.printStackTrace();
		} 

	}
}

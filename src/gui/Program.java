package gui;

import controller.ControllerFactory;

public class Program {

	public static void main(String args[]) {

		MainWindow main;
		try {
			
			main = new MainWindow(ControllerFactory.getOrdersController(new Database()));
			main.setVisible(true);	
			
		} catch (Exception e) {
			e.printStackTrace();
		} 

	}
}

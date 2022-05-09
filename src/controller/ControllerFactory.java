package controller;

import data.DataContext;

public class ControllerFactory {

	public static OrdersController getOrdersController(DataContext dataContext) throws Exception {
		
		if(dataContext == null) {
			throw new Exception("DataContext cannot be null");
		}
		
		return new OrdersControllerImplementation(dataContext);
	}
}

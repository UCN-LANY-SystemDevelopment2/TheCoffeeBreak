package data;

import data.daos.FakeOrderDao;
import data.daos.FakeProductDao;

public class DaoFactory {

	// TODO implement the factory methods so they instantiate the contrete dao implementation and return the object as the interface
	
	public static OrderDao createOrderDao() {
				
		return new FakeOrderDao();
	}
	
	public static ProductDao createProductDao() {
		
		return new FakeProductDao();
	}
}

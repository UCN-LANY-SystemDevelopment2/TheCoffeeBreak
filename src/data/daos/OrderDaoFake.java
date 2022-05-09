package data.daos;

import java.util.ArrayList;
import java.util.List;

import data.DataContext;
import data.OrderDao;
import model.Order;

public class OrderDaoFake implements OrderDao {

	public OrderDaoFake(DataContext dataContext) {
		
	}

	@Override
	public List<Order> getAll() {

		List<Order> result = new ArrayList<Order>();
		
		Order o1 = new Order();
		o1.setCustomer("Test1");
		o1.setDiscount(0);
		o1.setOrderNumber(1);
		o1.setStatus(Order.ACTIVE);		
		result.add(o1);
		
		Order o2 = new Order();
		o2.setCustomer("Test2");
		o2.setDiscount(0);
		o2.setOrderNumber(2);
		o2.setStatus(Order.ACTIVE);		
		result.add(o2);
		
		Order o3 = new Order();
		o3.setCustomer("Test2");
		o3.setDiscount(0);
		o3.setOrderNumber(2);
		o3.setStatus(Order.FINISHED);		
		result.add(o3);
		
		return result;
	}

	@Override
	public int create(Order order) {

		return 1;
	}

	@Override
	public int update(Order order) {

		
		return 1;
	}

	@Override
	public int delete(Order order) {

		return 0;
	}
}

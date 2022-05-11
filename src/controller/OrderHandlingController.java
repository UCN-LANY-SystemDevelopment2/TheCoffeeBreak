package controller;

import java.util.List;

import data.OrderDao;
import data.ProductDao;
import model.Order;
import model.Product;

public class OrderHandlingController {

	private final OrderDao orderDao;
	private final ProductDao productDao;

	public OrderHandlingController(OrderDao orderDao, ProductDao productDao) {

		this.orderDao = orderDao;
		this.productDao = productDao;
	}

	public List<Order> getActiveOrders() {

		List<Order> orders = orderDao.getAll();
		orders.removeIf(o -> o.getStatus() != Order.ACTIVE);
		return orders;
	}

	public boolean createNewOrder(Order order) {

		return orderDao.create(order) == 1;
	}

	public boolean setOrderStatusToFinished(Order order) {

		boolean result = false;

		order.setStatus(Order.FINISHED);
		result = orderDao.update(order) == 1;

		return result;
	}

	public List<Product> getAllProducts() {
		
		return productDao.getAll();
	}
}

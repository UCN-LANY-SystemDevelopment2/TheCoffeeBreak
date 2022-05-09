package controller;

import java.util.List;

import model.Order;
import model.Product;

public interface OrdersController {

	List<Order> getActiveOrders();

	List<Product> getAllProducts();
	
	boolean createNewOrder(Order order);
	
	boolean setOrderStatusToFinished(Order order);
}

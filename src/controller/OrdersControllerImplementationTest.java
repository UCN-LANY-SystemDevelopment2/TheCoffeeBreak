package controller;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import data.DataContext;
import model.Order;


class OrdersControllerImplementationTest {

	private OrdersController ctrl;
	
	@Test
	public void shouldThrowExceptionDueToDataContextIsNull() {

		try {

			// Arrange			
			DataContext dataContext = null;

			// Act, Assert
			Exception thrown = assertThrows(Exception.class, () -> {
				ControllerFactory.getOrdersController(dataContext);
			});			
			assertEquals("DataContext cannot be null", thrown.getMessage());

		} catch(Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void shouldCreateActiveOrderWithCustomerName() {
		try {
			
			// Arrange
			DataContext dataContext = new TestDatabase();

			ctrl = ControllerFactory.getOrdersController(dataContext);

			Order order = new Order();
			order.setCustomer("Test Customer");		
			order.setDiscount(0);
			order.setStatus(Order.ACTIVE);			

			// Act
			Boolean result = ctrl.createNewOrder(order);

			// Assert
			assertTrue(result);

		} catch (Exception e) {

			fail(e.getMessage());
		}	
	}
	
	@Test
public void shouldOnlyGetActiveOrders() {
	try {
		
		// Arrange
		DataContext dataContext = new TestDatabase();
		ctrl = ControllerFactory.getOrdersController(dataContext);
		
		// Act
		List<Order> orders = ctrl.getActiveOrders();

		// Assert
		assertEquals(2, orders.size());

	} catch (Exception e) {

		fail(e.getMessage());
	}	
}


class TestDatabase implements DataContext{

		private static final String serverName = "localhost\\sqlexpress";
		private static final String databaseName = "TheCoffeeBreak";
		private static final String username = "barista";
		private static final String password = "ThisIsALongPassword";

		private Connection connection = null;

		@Override
		public Connection getConnection() {

			if (connection == null) {

				try {

					SQLServerDataSource ds = new SQLServerDataSource();
					ds.setUser(username);
					ds.setPassword(password);
					ds.setServerName(serverName);
					ds.setDatabaseName(databaseName);
					connection = ds.getConnection();

				} catch (SQLServerException e) {

					e.printStackTrace();
				}
			}
			return connection;
		}

		@Override
		public Connection startTransaction() throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void commitTransaction() {
			// TODO Auto-generated method stub

		}

		@Override
		public void rollbackTransaction() {
			// TODO Auto-generated method stub

		}

	}
}

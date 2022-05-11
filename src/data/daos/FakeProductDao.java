package data.daos;

import java.util.ArrayList;
import java.util.List;

import data.ProductDao;
import model.Product;

public class FakeProductDao implements ProductDao {

	@Override
	public List<Product> getAll() {
		// TODO Auto-generated method stub
		return new ArrayList<Product>();
	}

}

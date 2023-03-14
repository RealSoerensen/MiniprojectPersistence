package dal.product;

import model.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductContainer implements ProductDBIF {
	private static ProductContainer instance = null;
	private final List<Product> products;
	
	private ProductContainer() {
		products = new ArrayList<>();
	}

	public static ProductContainer getInstance() {
		if(instance == null) {
			instance = new ProductContainer();
		}
		return instance;
	}

	@Override
	public boolean create(Object obj) {
		return products.add((Product) obj);
	}

	@Override
	public Object get(int id) {
		Product tempProduct = null;
		int i = 0;
		boolean found = false;

		while(i < products.size() && !found) {
			if(products.get(i).getId() == id) {
				tempProduct = products.get(i);
				found = true;
			}
		}

		return tempProduct;
	}

	@Override
	public List<Object> getAll() {
		return Collections.singletonList(products);
	}

	@Override
	public boolean update(Object obj) {
		boolean isUpdated = false;
		Product product = (Product) obj;
		int i = 0;
		boolean found = false;

		while(i < products.size() && !found) {
			if(products.get(i).getId() == product.getId()) {
				products.set(i, product);
				isUpdated = true;
				found = true;
			}
		}

		return isUpdated;
	}

	@Override
	public boolean delete(int id) {
		boolean isRemoved = false;
		Product product = (Product) get(id);
		if(products.contains(product)) {
			products.remove(product);
			isRemoved = true;
		}

		return isRemoved;
	}
}

package dal.product;

import model.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductContainer implements ProductDBIF {
	private static ProductContainer instance = null;
	private final List<Object> products;
	
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
	public Object get(long id) {
		Product tempProduct = null;
		int i = 0;
		boolean found = false;

		while(i < products.size() && !found) {
			Product product = (Product) products.get(i);
			if(product.getId() == id) {
				tempProduct = product;
				found = true;
			}
		}

		return tempProduct;
	}

	@Override
	public List<Object> getAll() {
		return products;
	}

	@Override
	public boolean update(Object obj) {
		boolean isUpdated = false;
		Product product = (Product) obj;
		int i = 0;
		boolean found = false;

		while(i < products.size() && !found) {
			Product tempProduct = (Product) products.get(i);
			if(tempProduct.getId() == product.getId()) {
				products.set(i, product);
				isUpdated = true;
				found = true;
			}
		}

		return isUpdated;
	}

	@Override
	public boolean delete(long id) {
		boolean isRemoved = false;
		Product product = (Product) get(id);
		if(products.contains(product)) {
			products.remove(product);
			isRemoved = true;
		}

		return isRemoved;
	}
}

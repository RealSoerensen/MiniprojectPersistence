package dal.customer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import model.Customer;

public class CustomerContainer implements CustomerDBIF {
	private static CustomerContainer instance = null;
	private final List<Object> customers;

	private CustomerContainer() {
		customers = new ArrayList<>();
	}

	public static CustomerContainer getInstance() {
		if (instance == null) {
			instance = new CustomerContainer();
		}
		return instance;
	}

	@Override
	public boolean create(Object obj) {
		return customers.add(obj);
	}

	@Override
	public Object get(long id) {
		int index = findCustomer(id);
		if (index >= 0) {
			return customers.get(index);
		}
		return null;
	}

	@Override
	public List<Object> getAll() {
		return customers;
	}

	@Override
	public boolean update(Object obj) {
		boolean isUpdated = false;
		Customer customer = (Customer) obj;
		int index = findCustomer(customer.getId());
		if (index >= 0) {
			customers.set(index, customer);
			isUpdated = true;
		}


		return isUpdated;
	}

	@Override
	public boolean delete(long id) {
		boolean isRemoved = false;
		Customer customer = (Customer) get(id);
		if (customers.contains(customer)) {
			customers.remove(customer);
			isRemoved = true;
		}
		return isRemoved;
	}

	private int findCustomer(long id) {
		int index = -1;
		for (int i = 0; i < customers.size(); i++) {
			Customer customer = (Customer) customers.get(i);
			if (customer.getId() == id) {
				index = i;
			}
		}
		return index;
	}
}

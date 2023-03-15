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
		Customer tempCustomer = null;
		int i = 0;
		boolean found = false;

		while (i < customers.size() && !found) {
			Customer customer = (Customer) customers.get(i);
			if (customer.getId() == id) {
				tempCustomer = customer;
				found = true;
			}
		}

		return tempCustomer;
	}

	@Override
	public List<Object> getAll() {
		return Collections.singletonList(customers);
	}

	@Override
	public boolean update(Object obj) {
		boolean isUpdated = false;
		Customer customer = (Customer) obj;
		int i = 0;
		boolean found = false;

		while (i < customers.size() && !found) {
			Customer tempCustomer = (Customer) customers.get(i);
			if (tempCustomer.getId() == customer.getId()) {
				customers.set(i, customer);
				isUpdated = true;
				found = true;
			}
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
}

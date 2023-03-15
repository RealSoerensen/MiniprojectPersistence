package dal.customer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import model.Customer;

public class CustomerContainer implements CustomerDBIF {
	private static CustomerContainer instance = null;
	private final List<Customer> customers;

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
		return customers.add((Customer) obj);
	}

	@Override
	public Object get(long id) {
		Customer tempcustomer = null;
		int index = findCustomer(id);
		if (index >= 0) {
			tempcustomer = customers.get(index);
		}

		return tempcustomer;
	}

	@Override
	public List<Object> getAll() {
		return Collections.singletonList(customers);
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
		int i = 0;
		boolean found = false;
		while (i < customers.size() && !found) {
			if (customers.get(i).getId() == id) {
				found = true;
			}
		}
		return i;
	}
}

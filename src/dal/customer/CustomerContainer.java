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
		if(instance == null) {
			instance = new CustomerContainer();
		}
		return instance;
	}

	@Override
	public boolean create(Object obj) {
		return customers.add((Customer) obj);
	}

	@Override
	public Object get(int id) {
		Customer tempcustomer = null;
		int i = 0;
		boolean found = false;

		while(i < customers.size() && !found) {
			if(customers.get(i).getID() == id) {
				tempcustomer = customers.get(i);
				found = true;
			}
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
		int i = 0;
		boolean found = false;

		while(i < customers.size() && !found) {
			if(customers.get(i).getID() == customer.getID()) {
				customers.set(i, customer);
				isUpdated = true;
				found = true;
			}
		}

		return isUpdated;
	}

	@Override
	public boolean delete(int phoneNo) {
		boolean isRemoved = false;
		Customer customer = (Customer) get(phoneNo);
		if(customers.contains(customer)) {
			customers.remove(customer);
			isRemoved = true;
		}

		return isRemoved;
	}
}

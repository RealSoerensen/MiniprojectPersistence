package dal.customer;

import java.util.Collections;
import java.util.List;

import model.Customer;

public class CustomerContainer implements CustomerDBIF {

    
    private List<Customer> customers;
	private long customerID; //Reference variable for customers.
	
	public CustomerContainer(long customerID) {
		this.customerID = customerID;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public long getCustomerID() {
		return customerID;
	}

	public void setCustomerID(List<Customer> customers) {
		this.customers = customers;
	}

	public void setCustomerID(long customerID) {
		this.customerID = customerID;
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

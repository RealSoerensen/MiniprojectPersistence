package dal.customer;

<<<<<<< Updated upstream
import java.util.List;

public class CustomerContainer implements CustomerDBIF {

    @Override
    public boolean create(Object obj) {
        return false;
    }
=======
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import model.Customer;
import model.Employee;

public class CustomerContainer implements CustomerDBIF {

    private static CustomerContainer instance;
    private List<Customer> customers;
	
	private CustomerContainer() {
		customers = new ArrayList<>();
	}
	
	public static CustomerContainer getInstance() {
        if (instance == null) {
            instance = new CustomerContainer();
        }
        return instance;
	}
>>>>>>> Stashed changes

    @Override
    public Object get(int id) {
        return null;
    }

<<<<<<< Updated upstream
    @Override
    public List<Object> getAll() {
        return null;
    }

    @Override
    public boolean update(Object obj) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
=======
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
	
	@Override
	public boolean login(String username, String password) {
        boolean validLogin = false;
        for(int i = 0; i < customers.size(); i++) {
            Customer e = customers.get(i);
            if (e.getUsername().equals(username) && e.getPassword().equals(password)) {
            	validLogin = true;
            }
        }
        return validLogin;
	}
>>>>>>> Stashed changes
}

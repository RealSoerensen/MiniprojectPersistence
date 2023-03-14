package controller;

import dal.customer.CustomerContainer;

public class CustomerController implements CustomerCtrIF {
	
	public boolean login(String username, String password) {
		return CustomerContainer.getInstance().login(username, password);
	}
}

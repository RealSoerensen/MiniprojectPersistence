package controller;

import dal.employee.EmployeeContainer;

public class EmployeeController implements EmployeeCtrIF {

	@Override
	public boolean login(String username, String password) {
		return EmployeeContainer.getInstance().login(username, password);
	}

}

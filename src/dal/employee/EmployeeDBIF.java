package dal.employee;

import dal.CRUD;

public interface EmployeeDBIF extends CRUD {
	boolean login(String username, String password);
}

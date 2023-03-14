package dal.employee;

import java.util.ArrayList;
import java.util.List;

import model.Employee;

public class EmployeeContainer implements EmployeeDBIF {
	private final List<Employee> employees;
	private static EmployeeContainer instance;

    private EmployeeContainer() {
        employees = new ArrayList<>();
    }

    public static EmployeeContainer getInstance() {
        if (instance == null) {
            instance = new EmployeeContainer();
        }
        return instance;
    }

    @Override
    public boolean create(Object obj) {
        return false;
    }

    @Override
    public Object get(int id) {
        return null;
    }

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

	@Override
	public boolean login(String username, String password) {
        boolean validLogin = false;
        for(int i = 0; i < employees.size(); i++) {
            Employee e = employees.get(i);
            if (e.getUsername().equals(username) && e.getPassword().equals(password)) {
            	validLogin = true;
            }
        }
        return validLogin;
	}
}

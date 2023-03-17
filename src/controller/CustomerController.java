package controller;

import dal.DatabaseManager;
import model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerController implements CustomerCtrIF {
    private DatabaseManager GenericDAO;

    public CustomerController(DatabaseManager GenericDAO) {
        setCustomerCtrIF(GenericDAO);
    }

    private void setCustomerCtrIF(DatabaseManager GenericDAO) {
        this.GenericDAO = GenericDAO;
    }

    @Override
    public boolean create(Customer obj) {
        return GenericDAO.create(obj);
    }

    @Override
    public Customer get(long id) {
        return GenericDAO.get(Customer.class, id);
    }

    @Override
    public List<Customer> getAll() {
        return new ArrayList<>(GenericDAO.getAll(Customer.class));
    }

    @Override
    public boolean update(Customer obj) {
        return GenericDAO.update(obj);
    }

    @Override
    public boolean delete(long id) {
        return GenericDAO.delete(Customer.class, id);
    }
}

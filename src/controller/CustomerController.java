package controller;

import dal.DatabaseManager;
import model.Customer;

import java.sql.SQLException;
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
    public boolean create(Customer obj) throws SQLException {
        return GenericDAO.create(obj);
    }

    @Override
    public Customer get(long id) throws SQLException {
        return GenericDAO.get(Customer.class, id);
    }

    @Override
    public List<Customer> getAll() throws SQLException {
        return new ArrayList<>(GenericDAO.getAll(Customer.class));
    }

    @Override
    public boolean update(Customer obj) throws SQLException {
        return GenericDAO.update(obj);
    }

    @Override
    public boolean delete(long id) throws SQLException {
        return GenericDAO.delete(Customer.class, id);
    }
}

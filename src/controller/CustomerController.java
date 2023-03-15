package controller;

import dal.customer.CustomerContainer;
import dal.customer.CustomerDBIF;
import model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerController implements CustomerCtrIF {
    private CustomerDBIF customerDBIF;

    public CustomerController(CustomerDBIF customerDBIF) {
        setCustomerCtrIF(customerDBIF);
    }

    private void setCustomerCtrIF(CustomerDBIF customerDBIF) {
        this.customerDBIF = customerDBIF;
    }

    public boolean create(Customer obj) {
        return customerDBIF.create(obj);
    }

    public Customer get(long id) {
        return (Customer) customerDBIF.get(id);
    }

    public List<Customer> getAll() {
        List<Customer> customers = new ArrayList<>();
        for(Object obj : customerDBIF.getAll()) {
            customers.add((Customer) obj);
        }
        return customers;
    }

    public boolean update(Customer obj) {
        return customerDBIF.update(obj);
    }

    public boolean delete(long id) {
        return customerDBIF.delete(id);
    }
}

package controller;

import dal.customer.CustomerContainer;
import dal.customer.CustomerDBIF;

import java.util.List;

public class CustomerController implements CustomerCtrIF {
    private CustomerDBIF customerDBIF;

    public CustomerController(CustomerDBIF customerDBIF) {
        setCustomerCtrIF(customerDBIF);
    }

    private void setCustomerCtrIF(CustomerDBIF customerDBIF) {
        this.customerDBIF = customerDBIF;
    }

    @Override
    public boolean create(Object obj) {
        return customerDBIF.create(obj);
    }

    @Override
    public Object get(long id) {
        return customerDBIF.get(id);
    }

    @Override
    public List<Object> getAll() {
        return customerDBIF.getAll();
    }

    @Override
    public boolean update(Object obj) {
        return customerDBIF.update(obj);
    }

    @Override
    public boolean delete(long id) {
        return customerDBIF.delete(id);
    }
}

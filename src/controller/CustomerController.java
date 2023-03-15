package controller;

import dal.customer.CustomerContainer;

import java.util.List;

public class CustomerController implements CustomerCtrIF {
    private CustomerCtrIF customerCtrIF;

    public CustomerController(CustomerCtrIF customerCtrIF) {
        setCustomerCtrIF(customerCtrIF);
    }

    private void setCustomerCtrIF(CustomerCtrIF customerCtrIF) {
        this.customerCtrIF = customerCtrIF;
    }

    @Override
    public boolean create(Object obj) {
        return customerCtrIF.create(obj);
    }

    @Override
    public Object get(long id) {
        return customerCtrIF.get(id);
    }

    @Override
    public List<Object> getAll() {
        return customerCtrIF.getAll();
    }

    @Override
    public boolean update(Object obj) {
        return customerCtrIF.update(obj);
    }

    @Override
    public boolean delete(long id) {
        return customerCtrIF.delete(id);
    }
}

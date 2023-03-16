package controller;

import model.Customer;

import java.util.List;

public interface CustomerCtrIF {
    boolean create(Customer obj);

    Customer get(long id);

    List<Customer> getAll();

    boolean update(Customer obj);

    boolean delete(long id);
}

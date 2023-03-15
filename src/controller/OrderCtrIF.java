package controller;

import dal.CRUD;
import org.junit.jupiter.api.Order;

import java.util.List;

public interface OrderCtrIF {
    boolean create(Order obj);
    Order get(long id);
    List<Order> getAll();
    boolean update(Order obj);
    boolean delete(long id);
}

package controller;

import model.OrderLine;

import java.util.List;

public interface OrderLineCtrIF {
    boolean create(OrderLine orderLine);
    OrderLine get(long id);
    List<OrderLine> getAll();
    boolean update(OrderLine orderLine);
    boolean delete(long id);
}

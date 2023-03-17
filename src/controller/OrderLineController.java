package controller;

import dal.DatabaseManager;
import model.OrderLine;

import java.util.List;

public class OrderLineController implements OrderLineCtrIF{
    final DatabaseManager orderLineDBIF;

    public OrderLineController(DatabaseManager orderLineDBIF) {
        this.orderLineDBIF = orderLineDBIF;
    }

    @Override
    public boolean create(OrderLine orderLine) {
        return orderLineDBIF.create(orderLine);
    }

    @Override
    public OrderLine get(long id) {
        return orderLineDBIF.get(OrderLine.class, id);
    }

    @Override
    public List<OrderLine> getAll() {
        return orderLineDBIF.getAll(OrderLine.class);
    }

    @Override
    public boolean update(OrderLine orderLine) {
        return orderLineDBIF.update(orderLine);
    }

    @Override
    public boolean delete(long id) {
        return orderLineDBIF.delete(OrderLine.class, id);
    }
}

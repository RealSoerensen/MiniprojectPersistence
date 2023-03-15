package controller;

import dal.order.OrderDBIF;
import org.junit.jupiter.api.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderController implements OrderCtrIF{
    private OrderDBIF orderDBIF;

    public OrderController(OrderDBIF orderDBIF) {
        setOrderCtrIF(orderDBIF);
    }

    private void setOrderCtrIF(OrderDBIF orderDBIF) {
        this.orderDBIF = orderDBIF;
    }

    public boolean create(Order obj) {
        return orderDBIF.create(obj);
    }

    public Order get(long id) {
        return (Order) orderDBIF.get(id);
    }

    public List<Order> getAll() {
        List<Order> orders = new ArrayList<>();
        for(Object obj : orderDBIF.getAll()) {
            orders.add((Order) obj);
        }
        return orders;
    }

    public boolean update(Order obj) {
        return orderDBIF.update(obj);
    }

    @Override
    public boolean delete(long id) {
        return orderDBIF.delete(id);
    }
}

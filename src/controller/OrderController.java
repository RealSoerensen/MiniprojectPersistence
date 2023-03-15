package controller;

import dal.order.OrderDBIF;

import java.util.List;

public class OrderController implements OrderCtrIF{
    private OrderDBIF orderDBIF;

    public OrderController(OrderDBIF orderDBIF) {
        setOrderCtrIF(orderDBIF);
    }

    private void setOrderCtrIF(OrderDBIF orderDBIF) {
        this.orderDBIF = orderDBIF;
    }

    @Override
    public boolean create(Object obj) {
        return orderDBIF.create(obj);
    }

    @Override
    public Object get(long id) {
        return orderDBIF.get(id);
    }

    @Override
    public List<Object> getAll() {
        return orderDBIF.getAll();
    }

    @Override
    public boolean update(Object obj) {
        return orderDBIF.update(obj);
    }

    @Override
    public boolean delete(long id) {
        return orderDBIF.delete(id);
    }
}

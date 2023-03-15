package controller;

import java.util.List;

public class OrderController implements OrderCtrIF{
    private OrderCtrIF orderCtrIF;

    public OrderController(OrderCtrIF orderCtrIF) {
        setOrderCtrIF(orderCtrIF);
    }

    private void setOrderCtrIF(OrderCtrIF orderCtrIF) {
        this.orderCtrIF = orderCtrIF;
    }

    @Override
    public boolean create(Object obj) {
        return orderCtrIF.create(obj);
    }

    @Override
    public Object get(long id) {
        return orderCtrIF.get(id);
    }

    @Override
    public List<Object> getAll() {
        return orderCtrIF.getAll();
    }

    @Override
    public boolean update(Object obj) {
        return orderCtrIF.update(obj);
    }

    @Override
    public boolean delete(long id) {
        return orderCtrIF.delete(id);
    }
}

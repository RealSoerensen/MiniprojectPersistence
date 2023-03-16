package controller;

import dal.saleorder.SaleOrderDBIF;
import org.junit.jupiter.api.Order;

import java.util.ArrayList;
import java.util.List;

public class SaleOrderController implements SaleOrderCtrIF {
    private SaleOrderDBIF orderDBIF;

    public SaleOrderController(SaleOrderDBIF orderDBIF) {
        setOrderCtrIF(orderDBIF);
    }

    private void setOrderCtrIF(SaleOrderDBIF orderDBIF) {
        this.orderDBIF = orderDBIF;
    }

    @Override
    public boolean create(Order obj) {
        return orderDBIF.create(obj);
    }

    @Override
    public Order get(long id) {
        return (Order) orderDBIF.get(id);
    }

    @Override
    public List<Order> getAll() {
        List<Order> orders = new ArrayList<>();
        for(Object obj : orderDBIF.getAll()) {
            orders.add((Order) obj);
        }
        return orders;
    }

    @Override
    public boolean update(Order obj) {
        return orderDBIF.update(obj);
    }

    @Override
    public boolean delete(long id) {
        return orderDBIF.delete(id);
    }
}

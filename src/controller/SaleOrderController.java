package controller;

import dal.DatabaseManager;
import model.SaleOrder;

import java.util.ArrayList;
import java.util.List;

public class SaleOrderController implements SaleOrderCtrIF {
    private DatabaseManager orderDBIF;

    public SaleOrderController(DatabaseManager orderDBIF) {
        setOrderCtrIF(orderDBIF);
    }

    private void setOrderCtrIF(DatabaseManager orderDBIF) {
        this.orderDBIF = orderDBIF;
    }

    @Override
    public boolean create(SaleOrder obj) {
        return orderDBIF.create(obj);
    }

    @Override
    public SaleOrder get(long id) {
        return orderDBIF.get(SaleOrder.class, id);
    }

    @Override
    public List<SaleOrder> getAll() {
        return new ArrayList<>(orderDBIF.getAll(SaleOrder.class));
    }

    @Override
    public boolean update(SaleOrder obj) {
        return orderDBIF.update(obj);
    }

    @Override
    public boolean delete(long id) {
        return orderDBIF.delete(SaleOrder.class, id);
    }
}

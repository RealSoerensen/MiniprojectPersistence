package controller;

import model.SaleOrder;

import java.util.List;

public interface SaleOrderCtrIF {
    boolean create(SaleOrder obj);

    SaleOrder get(long id);

    List<SaleOrder> getAll();

    boolean update(SaleOrder obj);

    boolean delete(long id);
}

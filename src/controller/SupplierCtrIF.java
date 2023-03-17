package controller;

import model.Supplier;

public interface SupplierCtrIF {
    boolean create(Supplier supplier);
    Supplier get(long id);
    boolean update(Supplier supplier);
    boolean delete(long id);
}

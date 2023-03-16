package controller;

import model.Supplier;

public interface SupplierCtrIF {
    boolean createSupplier(Supplier supplier);
    Supplier getSupplier(int id);
    boolean updateSupplier(Supplier supplier);
    boolean deleteSupplier(int id);
}

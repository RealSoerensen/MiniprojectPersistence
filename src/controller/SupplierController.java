package controller;

import dal.supplier.SupplierDBIF;
import model.Supplier;

public class SupplierController implements SupplierCtrIF{
    private SupplierDBIF supplierDBIF;

    public SupplierController(SupplierDBIF supplierDBIF) {
        this.supplierDBIF = supplierDBIF;
    }

    @Override
    public boolean createSupplier(Supplier supplier) {
        boolean result = false;
        try {
            result = supplierDBIF.create(supplier);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Supplier getSupplier(int id) {
        return (Supplier) supplierDBIF.get(id);
    }

    @Override
    public boolean updateSupplier(Supplier supplier) {
        boolean result = false;
        try {
            result = supplierDBIF.update(supplier);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean deleteSupplier(int id) {
        boolean result = false;
        try {
            result = supplierDBIF.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}

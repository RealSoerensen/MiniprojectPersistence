package dal.saleorder;

import dal.CRUD;

public interface SaleOrderDBIF extends CRUD {
    boolean addProductToOrderLine(long id);
}

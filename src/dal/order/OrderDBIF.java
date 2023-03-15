package dal.order;

import dal.CRUD;

public interface OrderDBIF extends CRUD {
    boolean addProductToOrderLine(long id);
}

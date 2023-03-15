package dal.order;

import dal.CRUD;

public interface OrderDBIF extends CRUD {
    Object get(long id);
}

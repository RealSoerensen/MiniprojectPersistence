package dal.order;

import java.util.List;

public class OrderDB implements OrderDBIF {
    @Override
    public boolean create(Object obj) {
        return false;
    }

    @Override
    public Object get(long id) {
        return null;
    }

    @Override
    public List<Object> getAll() {
        return null;
    }

    @Override
    public boolean update(Object obj) {
        return false;
    }

    @Override
    public boolean delete(long id) {
        return false;
    }

    @Override
    public boolean addProductToOrderLine(long id) {
        return false;
    }
}

package dal.customer;

import java.util.List;

public class CustomerDB implements CustomerDBIF {
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
}

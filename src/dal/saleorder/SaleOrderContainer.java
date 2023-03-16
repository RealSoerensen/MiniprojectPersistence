package dal.saleorder;

import java.util.ArrayList;
import java.util.List;

public class SaleOrderContainer implements SaleOrderDBIF {
    private static SaleOrderContainer instance = null;
    private final List<Object> orders;

    private SaleOrderContainer() {
        orders = new ArrayList<>();
    }

    public static SaleOrderContainer getInstance() {
        if (instance == null) {
            instance = new SaleOrderContainer();
        }
        return instance;
    }

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

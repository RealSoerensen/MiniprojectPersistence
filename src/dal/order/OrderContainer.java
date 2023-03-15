package dal.order;



import model.SaleOrder;

import java.util.ArrayList;
import java.util.List;

public class OrderContainer implements OrderDBIF {
    private static OrderContainer instance = null;
    private final List<Object> orders;

    private OrderContainer() {
        orders = new ArrayList<>();
    }

    public static OrderContainer getInstance() {
        if(instance == null) {
            instance = new OrderContainer();
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

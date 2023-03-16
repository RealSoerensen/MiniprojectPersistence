package dal.saleorder;

import dal.DBConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class SaleOrderDB implements SaleOrderDBIF {
    DBConnection dbConnection;
    Connection con;

    public SaleOrderDB() throws SQLException {
        dbConnection = DBConnection.getInstance();
        con = DBConnection.getConnection();
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

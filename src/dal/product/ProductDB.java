package dal.product;

import dal.DBConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ProductDB implements ProductDBIF {
    private static ProductDB instance = null;
    private DBConnection dbConnection;
    private Connection con;

    private ProductDB() throws SQLException {
        dbConnection = DBConnection.getInstance();
        con = dbConnection.getConnection();
    }

    public static ProductDB getInstance() throws SQLException {
        if (instance == null) {
            instance = new ProductDB();
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
}

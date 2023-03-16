package dal.supplier;

import dal.DBConnection;
import model.Supplier;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SupplierDB implements SupplierDBIF{
    DBConnection dbConnection;
    Connection con;

    public SupplierDB() throws SQLException {
        dbConnection = DBConnection.getInstance();
        con = dbConnection.getConnection();
    }

    @Override
    public boolean create(Object obj) {
        boolean result = false;

        if (!(obj instanceof Supplier supplier)) {
            return result;
        }

        try (PreparedStatement stmt = con.prepareStatement(
                "INSERT INTO Supplier (name, address, country, phoneNo, email) VALUES (?, ?, ?, ?, ?)")) {
            stmt.setString(1, supplier.getName());
            stmt.setString(2, supplier.getAddress());
            stmt.setString(3, supplier.getCountry());
            stmt.setString(4, supplier.getPhoneNo());
            stmt.setString(5, supplier.getEmail());

            int rowsAffected = stmt.executeUpdate();
            result = (rowsAffected > 0);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public Object get(long id) {
        Supplier supplier = null;

        try (PreparedStatement stmt = con.prepareStatement(
                "SELECT * FROM Supplier WHERE supplierId = ?")) {
            stmt.setLong(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    supplier = new Supplier(
                            rs.getLong("supplierId"),
                            rs.getString("name"),
                            rs.getString("address"),
                            rs.getString("country"),
                            rs.getString("phoneNo"),
                            rs.getString("email"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return supplier;
    }

    @Override
    public List<Object> getAll() {
        List<Object> suppliers = new ArrayList<>();

        try (PreparedStatement stmt = con.prepareStatement(
                "SELECT supplierId, name, address, country, phoneNo, email FROM Supplier");
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                suppliers.add(new Supplier(
                        rs.getLong("supplierId"),
                        rs.getString("name"),
                        rs.getString("address"),
                        rs.getString("country"),
                        rs.getString("phoneNo"),
                        rs.getString("email")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return suppliers;
    }

    @Override
    public boolean update(Object obj) {
        boolean result = false;
        Supplier supplier = (Supplier) obj;

        try (PreparedStatement stmt = con.prepareStatement(
                "UPDATE Supplier SET name = ?, address = ?, country = ?, phoneNo = ?, email = ? WHERE supplierId = ?")) {
            stmt.setString(1, supplier.getName());
            stmt.setString(2, supplier.getAddress());
            stmt.setString(3, supplier.getCountry());
            stmt.setString(4, supplier.getPhoneNo());
            stmt.setString(5, supplier.getEmail());
            stmt.setLong(6, supplier.getId());

            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                result = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public boolean delete(long id) {
        boolean result = false;

        try (PreparedStatement stmt = con.prepareStatement(
                "DELETE FROM Supplier WHERE supplierId = ?")) {
            stmt.setLong(1, id);

            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                result = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
}

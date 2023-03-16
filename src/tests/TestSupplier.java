package tests;

import controller.SupplierController;
import dal.DBConnection;
import dal.supplier.SupplierDB;
import model.Supplier;
import org.junit.jupiter.api.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.*;

public class TestSupplier {
    private static SupplierController supplierController;
    static DBConnection dbConnection;
    static Connection con;

    @BeforeAll
    static void setUp() throws SQLException {
        dbConnection = DBConnection.getInstance();
        con = DBConnection.getConnection();
        supplierController = new SupplierController(new SupplierDB());
    }

    @Test
    void testCreate() {
        // Arrange
        Supplier supplier = new Supplier(1, "Test", "Test", "Test", "Test", "Test");
        Supplier supplier2 = new Supplier(2, "Test", "Test", "Test", "Test", "Test");

        // Act
        boolean result = supplierController.createSupplier(supplier);
        boolean result2 = supplierController.createSupplier(supplier2);

        // Assert
        assertTrue(result);
        assertTrue(result2);
    }

    @Test
    void testGet() {
        // Arrange
        Supplier supplier = new Supplier(1, "Test", "Test", "Test", "Test", "Test");
        Supplier supplier2 = new Supplier(2, "Test", "Test", "Test", "Test", "Test");
        supplierController.createSupplier(supplier);
        supplierController.createSupplier(supplier2);
        int id = 2;

        // Act
        Supplier supplier3 = supplierController.getSupplier(id);

        // Assert
        assertEquals(id, supplier3.getId());
    }

    @Test
    void testUpdate() {
        // Arrange
        Supplier supplier = new Supplier(1, "Test", "Test", "Test", "Test", "Test");
        supplierController.createSupplier(supplier);

        // Act
        supplier.setName("Test2");
        boolean result = supplierController.updateSupplier(supplier);

        // Assert
        assertTrue(result);
    }

    @Test
    void testDelete() {
        // Arrange
        Supplier supplier = new Supplier(1, "Test", "Test", "Test", "Test", "Test");
        supplierController.createSupplier(supplier);
        int id = 1;

        // Act
        boolean result = supplierController.deleteSupplier(id);

        // Assert
        assertTrue(result);
    }

    @AfterEach
    void tearDown() throws SQLException {
        dbConnection.resetDatabase();
    }
}

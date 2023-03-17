package tests;

import controller.OrderLineController;
import controller.ProductController;
import controller.SupplierController;
import dal.DBConnection;
import dal.DatabaseManager;
import model.OrderLine;
import model.Product;
import model.Supplier;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.SQLException;

public class TestOrderLine {
    final DatabaseManager genericDAO = new DatabaseManager();
    final OrderLineController orderLineCtr = new OrderLineController(genericDAO);
    final SupplierController supplierCtr = new SupplierController(genericDAO);
    final ProductController productCtr = new ProductController(genericDAO);
    static final DBConnection dbConnection;

    static {
        try {
            dbConnection = DBConnection.getInstance();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    static Connection con = DBConnection.getConnection();

    public TestOrderLine() throws SQLException {
    }


    @BeforeEach
    public void setupEach() {
        Supplier supplier = new Supplier(1, "TestName", "TestAddress", "TestCountry", "TestPhone", "TestEmail");
        supplierCtr.create(supplier);
        Product product = new Product(1, 1, "TestName", "TestBrand", 50, 100, "TestCountry", 4, 5, "TestDesc", "TestCategory");
        productCtr.create(product);
    }

    @Test
    public void testCreate() {
        // Arrange
        OrderLine orderLine = new OrderLine(1, 1, 1, 1);
        OrderLine orderLine2 = new OrderLine(2, 2, 2, 1);

        // Act
        boolean result = orderLineCtr.create(orderLine);
        boolean result2 = orderLineCtr.create(orderLine2);

        // Assert
        assertTrue(result);
        assertTrue(result2);
    }

    @Test
    public void testGet() {
        // Arrange
        OrderLine orderLine = new OrderLine(1, 1, 1, 1);
        OrderLine orderLine2 = new OrderLine(2, 2, 2, 1);
        orderLineCtr.create(orderLine);
        orderLineCtr.create(orderLine2);
        int id = 2;

        // Act
        OrderLine orderLine3 = orderLineCtr.get(id);

        // Assert
        assertEquals(id, orderLine3.getOrderLineId());
    }

    @Test
    public void testUpdate() {
        // Arrange
        OrderLine orderLine = new OrderLine(1, 1, 1, 1);
        OrderLine orderLine2 = new OrderLine(2, 2, 2, 1);
        orderLineCtr.create(orderLine);
        orderLineCtr.create(orderLine2);
        int id = 2;
        OrderLine orderLine3 = orderLineCtr.get(id);
        orderLine3.setQuantity(3);

        // Act
        boolean result = orderLineCtr.update(orderLine3);

        // Assert
        assertTrue(result);
    }

    @Test
    public void testDelete() {
        // Arrange
        OrderLine orderLine = new OrderLine(1, 1, 1, 1);
        OrderLine orderLine2 = new OrderLine(2, 2, 2, 1);
        orderLineCtr.create(orderLine);
        orderLineCtr.create(orderLine2);
        int id = 2;

        // Act
        boolean result = orderLineCtr.delete(id);

        // Assert
        assertTrue(result);
    }

    @Test
    public void testGetAll() {
        // Arrange
        OrderLine orderLine = new OrderLine(1, 1, 1, 1);
        OrderLine orderLine2 = new OrderLine(2, 2, 2, 1);
        orderLineCtr.create(orderLine);
        orderLineCtr.create(orderLine2);

        // Act
        int result = orderLineCtr.getAll().size();

        // Assert
        assertEquals(2, result);
    }

    @AfterEach
    public void tearDownEach() throws SQLException {
        dbConnection.resetDatabase();
    }

}

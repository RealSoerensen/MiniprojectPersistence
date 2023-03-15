package tests;

import controller.ProductController;
import dal.product.ProductContainer;
import model.Product;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class TestProducts {
    ProductContainer productContainer;
    ProductController productController;

    @BeforeEach
    public void setup() {
        productContainer = ProductContainer.getInstance();
        productController = new ProductController(productContainer);
    }

    @Test
    public void testProductContainer() {
        assertNotNull(productContainer);

    }

    @Test
    public void testCreate() {
        // Arrange
        Product product = new Product(1, 100, "TestName", "TestBrand", 50, 100, "TestCountry", 4, 5, "TestDesc", "TestCategory");

        // Act
        boolean result = productController.create(product);

        // Assert
        assertTrue(result);
    }

    @Test
    public void testProductContainerGet() {
        // Arrange
        Product product = new Product(1, 100, "TestName", "TestBrand", 50, 100, "TestCountry", 4, 5, "TestDesc", "TestCategory");
        productController.create(product);

        // Act
        product = productController.get(1);

        // Assert
        assertEquals(1, product.getId());
    }

    @Test
    public void testGetAll() {
        // Arrange
        Product product = new Product(1, 100, "TestName", "TestBrand", 50, 100, "TestCountry", 4, 5, "TestDesc", "TestCategory");

        // Act
        productController.create(product);
        List<Product> products = productController.getAll();

        // Assert
        assertEquals(1, products.size());
    }

    @Test
    public void testProductContainerUpdate() {
        // Arrange
        Product product = new Product(1, 100, "TestName", "TestBrand", 50, 100, "TestCountry", 4, 5, "TestDesc", "TestCategory");

        // Act
        productController.create(product);
        product.setSalesPrice(200);
        productController.update(product);

        // Assert
        Product product2 = productController.get(1);
        assertEquals(200, product2.getSalesPrice());

    }

    @Test
    public void testProductContainerDelete() {
        // Arrange
        Product product = new Product(1, 100, "TestName", "TestBrand", 50, 100, "TestCountry", 4, 5, "TestDesc", "TestCategory");

        // Act
        productController.create(product);
        productController.delete(1);

        // Assert
        Product product2 = productController.get(1);
        assertNull(product2);
    }

    @Test
    public void testProductContainerGetAll() {
        // Arrange
        Product product = new Product(1, 100, "TestName", "TestBrand", 50, 100, "TestCountry", 4, 5, "TestDesc", "TestCategory");
        Product product2 = new Product(2, 100, "TestName", "TestBrand", 50, 100, "TestCountry", 4, 5, "TestDesc", "TestCategory");

        // Act
        productController.create(product);
        productController.create(product2);
        List<Object> products = productContainer.getAll();

        // Assert
        assertEquals(2, products.size());
    }

    @AfterEach
    public void tearDown() {
        productContainer = null;
    }
}

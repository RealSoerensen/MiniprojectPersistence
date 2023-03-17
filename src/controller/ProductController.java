package controller;

import dal.DatabaseManager;
import model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductController implements ProductCtrIF{
    private DatabaseManager productDBIF;

    public ProductController(DatabaseManager productCtrIF) {
        setProductCtrIF(productCtrIF);
    }

    private void setProductCtrIF(DatabaseManager productCtrIF) {
        this.productDBIF = productCtrIF;
    }

    @Override
    public boolean create(Product obj) {
        return productDBIF.create(obj);
    }

    @Override
    public Product get(long id) {
        return productDBIF.get(Product.class, id);
    }

    @Override
    public List<Product> getAll() {
        return new ArrayList<>(productDBIF.getAll(Product.class));
    }

    @Override
    public boolean update(Product obj) {
        return productDBIF.update(obj);
    }

    @Override
    public boolean delete(long id) {
        return productDBIF.delete(Product.class, id);
    }
}

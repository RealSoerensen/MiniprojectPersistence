package controller;

import dal.product.ProductDBIF;
import model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductController implements ProductCtrIF{
    private ProductDBIF productDBIF;

    public ProductController(ProductDBIF productCtrIF) {
        setProductCtrIF(productCtrIF);
    }

    private void setProductCtrIF(ProductDBIF productCtrIF) {
        this.productDBIF = productCtrIF;
    }

    @Override
    public boolean create(Product obj) {
        return productDBIF.create(obj);
    }

    @Override
    public Product get(long id) {
        return (Product) productDBIF.get(id);
    }

    @Override
    public List<Product> getAll() {
        List<Product> products = new ArrayList<>();
        for(Object obj : productDBIF.getAll()) {
            products.add((Product) obj);
        }
        return products;
    }

    @Override
    public boolean update(Product obj) {
        return productDBIF.update(obj);
    }

    @Override
    public boolean delete(long id) {
        return productDBIF.delete(id);
    }
}

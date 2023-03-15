package controller;

import dal.product.ProductDBIF;

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
    public boolean create(Object obj) {
        return productDBIF.create(obj);
    }

    @Override
    public Object get(long id) {
        return productDBIF.get(id);
    }

    @Override
    public List<Object> getAll() {
        return productDBIF.getAll();
    }

    @Override
    public boolean update(Object obj) {
        return productDBIF.update(obj);
    }

    @Override
    public boolean delete(long id) {
        return productDBIF.delete(id);
    }
}

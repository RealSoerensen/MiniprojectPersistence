package controller;

import java.util.List;

public class ProductController implements ProductCtrIF{
    private ProductCtrIF productCtrIF;

    public ProductController(ProductCtrIF productCtrIF) {
        setProductCtrIF(productCtrIF);
    }

    private void setProductCtrIF(ProductCtrIF productCtrIF) {
        this.productCtrIF = productCtrIF;
    }

    @Override
    public boolean create(Object obj) {
        return productCtrIF.create(obj);
    }

    @Override
    public Object get(long id) {
        return productCtrIF.get(id);
    }

    @Override
    public List<Object> getAll() {
        return productCtrIF.getAll();
    }

    @Override
    public boolean update(Object obj) {
        return productCtrIF.update(obj);
    }

    @Override
    public boolean delete(long id) {
        return productCtrIF.delete(id);
    }
}

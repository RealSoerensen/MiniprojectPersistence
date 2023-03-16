package controller;

import model.Product;

import java.util.List;

public interface ProductCtrIF {
    boolean create(Product obj);

    Product get(long id);

    List<Product> getAll();

    boolean update(Product obj);

    boolean delete(long id);
}

package greta.cda.bakeryproject.dao;

import greta.cda.bakeryproject.entity.Product;

import java.util.List;

public interface ProductDao {
    List<Product> findAll();

    void add(Product product);

    Product findById(int id);

    void deleteById(int id);

    void update(Product product);

    List<Product> findProductContainingName(String Name);
}


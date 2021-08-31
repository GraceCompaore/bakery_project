package greta.cda.bakeryproject.dao;

import greta.cda.bakeryproject.domain.Product;

import java.util.List;

public interface ProductDao {
    List<Product> findAll();
    void add(Product product);
    List <Product> findById();

    //List<Product> findProductContainingName(String searchedName);
}


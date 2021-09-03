package greta.cda.bakeryproject.dao;

import greta.cda.bakeryproject.domain.Product;

import java.util.List;
import java.util.UUID;

public interface ProductDao {
    List<Product> findAll();
    void add(Product product);
    Product findById(String id);
    void deleteById(String id);
    void update (Product product);



    //List<Product> findProductContainingName(String searchedName);
}


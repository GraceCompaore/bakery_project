package greta.cda.bakeryproject.dao;

import greta.cda.bakeryproject.domain.Product;

import java.util.List;
import java.util.UUID;

public interface ProductDao {
    List<Product> findAll();
    void add(Product product);
    Product findById(UUID id);

    //List<Product> findProductContainingName(String searchedName);
}


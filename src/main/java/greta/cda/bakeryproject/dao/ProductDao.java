package greta.cda.bakeryproject.dao;

import greta.cda.bakeryproject.entity.Product;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductDao {
    List<Product> findAll();

    Product add(Product product);

    Optional<Product> findById(UUID id);

    void deleteById(UUID id);

    Product update(Product product);

    List<Product> findProductContainingName(String Name);
}


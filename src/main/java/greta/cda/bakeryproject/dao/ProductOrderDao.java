package greta.cda.bakeryproject.dao;

import greta.cda.bakeryproject.entity.ProductOrder;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductOrderDao {
    List<ProductOrder> findAll();

    ProductOrder add(ProductOrder productOrder);

    Optional<ProductOrder> findById(UUID id);

    void deleteById(UUID id);

    ProductOrder update(ProductOrder productOrder);

}

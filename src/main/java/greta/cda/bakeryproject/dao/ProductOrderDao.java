package greta.cda.bakeryproject.dao;

import greta.cda.bakeryproject.entity.ProductOrder;

import java.util.List;

public interface ProductOrderDao {
    List<ProductOrder> findAll();

    void add(ProductOrder productOrder);

    ProductOrder findById(int id);

    void deleteById(int id);

    void update(ProductOrder productOrder);

}

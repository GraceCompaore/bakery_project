package greta.cda.bakeryproject.dao;

import greta.cda.bakeryproject.entity.ProductOrder;

import java.util.List;

public interface ProductOrderDao {

     void add (ProductOrder productOrder);
    List<ProductOrder> findAll();
    void deleteById(int id);
}

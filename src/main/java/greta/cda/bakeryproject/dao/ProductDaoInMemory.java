package greta.cda.bakeryproject.dao;

import greta.cda.bakeryproject.domain.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class ProductDaoInMemory implements ProductDao{
    private List<Product> productList = new ArrayList<>();
    private List<Product> productUnique = new ArrayList<>();


    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public void add(Product product) {
        productList.add(product);
    }

    @Override
    public List<Product> findById() {
        return productUnique;
    }


/*
    public List<Product> findProductContainingName(String name) {
        return productList.stream()
                .filter(product -> product.name().toLowerCase().contains(name.toLowerCase())
                        .collect(Collectors.toList()));
    }*/
}
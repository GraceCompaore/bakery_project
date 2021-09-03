package greta.cda.bakeryproject.dao;

import greta.cda.bakeryproject.domain.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import java.util.stream.Collectors;


public class ProductDaoInMemory implements ProductDao{
    private List<Product> productList = new ArrayList<>();

    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public void add(Product product) {
        productList.add(product);
    }

    @Override
    public Product findById(String id) {
        return productList.stream()
                .filter(product -> product.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void deleteById(String id){
        productList.removeIf(product -> product.getId().equals(id));

    }

    @Override
    public void update (Product product){
        int index = -1;
        for (int i = 0; i < productList.size(); i++) {
            if (product.getId().equals(productList.get(i).getId())) {
                index = i;
            }
        }
        productList.set(index, product);
    }
    }


/*
    public List<Product> findProductContainingName(String name) {
        return productList.stream()
                .filter(product -> product.name().toLowerCase().contains(name.toLowerCase())
                        .collect(Collectors.toList()));
    }*/

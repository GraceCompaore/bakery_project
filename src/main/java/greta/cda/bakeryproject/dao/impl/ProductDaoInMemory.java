package greta.cda.bakeryproject.dao.impl;

import greta.cda.bakeryproject.dao.ProductDao;
import greta.cda.bakeryproject.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductDaoInMemory implements ProductDao {
    private final List<Product> productList = new ArrayList<>();

    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public void add(Product product) {
        productList.add(product);
    }

    @Override
    public Product findById(int id) {
        return productList.stream()
                .filter(product -> product.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void deleteById(int id) {
        productList.removeIf(product -> product.getId() == id);

    }

    @Override
    public void update(Product product) {
        int index = -1;
        for (int i = 0; i < productList.size(); i++) {
            if (product.getId().equals(productList.get(i).getId())) {
                index = i;
            }
        }
        productList.set(index, product);
    }

    @Override
    public List<Product> findProductContainingName(String Name) {
        return null;
    }
}
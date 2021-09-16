package greta.cda.bakeryproject.dao.impl;

import greta.cda.bakeryproject.dao.ProductDao;
import greta.cda.bakeryproject.entity.Product;
import greta.cda.bakeryproject.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Primary
public class ProductDaoInDb implements ProductDao {
    private final ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void add(Product product) {
        productRepository.save(product);
    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(int id) {
        productRepository.deleteById(id);
    }

    @Override
    public void update(Product product) {
        productRepository.save(product);
    }

    @Override
    public List<Product> findProductContainingName(String name) {
        return productRepository.findAllByNameContaining(name);
    }
}

package greta.cda.bakeryproject.service;

import greta.cda.bakeryproject.dao.CategoryDao;
import greta.cda.bakeryproject.dao.ProductDao;
import greta.cda.bakeryproject.dto.CreateProductDto;
import greta.cda.bakeryproject.entity.Category;
import greta.cda.bakeryproject.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductDao productDao;
    private final  CategoryDao categoryDao;

    public List<Product> findAll() {
        return productDao.findAll();
    }

    @Transactional
    public Product add(CreateProductDto productDto) {
        Category category = categoryDao.findByLabel(productDto.getCategory())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Product category with label=%s not found", productDto.getCategory())));

        Product product = new Product();
        product.setCategory(category);
        product.setCover(productDto.getCover());
        product.setPrice(productDto.getPrice());
        product.setName(productDto.getName());
        product.setQuantity(productDto.getQuantity());

        return productDao.add(product);
    }

    public Product findById(String id) {
        return productDao.findById(UUID.fromString(id))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Product with id=%s not found", id)));
    }

    public void deleteById(String id) {
        productDao.deleteById(UUID.fromString(id));
    }

    @Transactional
    public Product update(String id, Product product) {
        Product productToUpdate = productDao.findById(UUID.fromString(id))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Product with id=%s not found", id)));

        productToUpdate.setPrice(product.getPrice());
        productToUpdate.setQuantity(product.getQuantity());
        productToUpdate.setName(product.getName());
        productToUpdate.setCover(product.getCover());
        productToUpdate.setCategory(product.getCategory());

        return productDao.update(productToUpdate);
    }

    public List<Product> findProductContainingName(String name) {
        return productDao.findProductContainingName(name);
    }
}


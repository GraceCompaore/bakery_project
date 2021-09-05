package greta.cda.bakeryproject.service;

import greta.cda.bakeryproject.dao.ProductDao;
import greta.cda.bakeryproject.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductDao productDao;

    public ProductService(ProductDao productDao) {
        this.productDao = productDao;
    }

    public List<Product> findAll() {
        return productDao.findAll();
    }

    //Add product in list
    public void add(int id, String name, int quantity, int price) {
        Product item = new Product(id, name, quantity, price);
        productDao.add(item);
    }

    public Product findById(int id) {
        return productDao.findById(id);
    }

    public void deleteById(int id) {
        productDao.deleteById(id);
    }

    public void update(int id, Product product) {
        Product myActualProduct = findById(id);
        if (product.getName() != null) {
            myActualProduct.setName(product.getName());
        }
        productDao.update(myActualProduct);
    }
}


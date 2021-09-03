package greta.cda.bakeryproject.service;

import greta.cda.bakeryproject.dao.ProductDao;
import greta.cda.bakeryproject.domain.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {
    private ProductDao productDao;

    public ProductService(ProductDao productDao) {
        this.productDao = productDao;
    }

    public List<Product> findAll() {
        return productDao.findAll();
    }

    //Add product in list
    public void add(String id, String name, int quantity, int price) {
        Product item = new Product(id, name, quantity, price);
        productDao.add(item);
    }

    public Product findById(String id) {
        return productDao.findById(id);
    }

    public void deleteById(String id)
    {
        productDao.deleteById(id);
    }

    public void update(String id, Product product) {
        Product myActualProduct = findById(id);
        if(product.getName() !=null){
            myActualProduct.setName(product.getName());
        }
        productDao.update(myActualProduct);
    }
}


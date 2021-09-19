package greta.cda.bakeryproject.service;

import greta.cda.bakeryproject.dao.ProductDao;
import greta.cda.bakeryproject.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductDao productDao;

    public List<Product> findAll() {
        return productDao.findAll();
    }

    /**
     * Add product in list
     *
     * @param name
     * @param quantity
     * @param unitPrice
     */
    public void add(String name, int quantity, double unitPrice) {
        Product item = new Product(name, quantity, unitPrice);
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

        if (myActualProduct != null) {
            myActualProduct.setName(product.getName());
            myActualProduct.setQuantity(product.getQuantity());
            myActualProduct.setUnitPrice(product.getUnitPrice());

            productDao.update(myActualProduct);
        }
    }

    public List<Product> findProductContainingName(String name) {
        return productDao.findProductContainingName(name);

    }
}


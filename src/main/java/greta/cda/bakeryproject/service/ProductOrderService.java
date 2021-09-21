package greta.cda.bakeryproject.service;

import greta.cda.bakeryproject.dao.ProductOrderDao;
import greta.cda.bakeryproject.entity.Command;
import greta.cda.bakeryproject.entity.Product;
import greta.cda.bakeryproject.entity.ProductOrder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductOrderService {

    private final ProductOrderDao productOrderDao;

    public List<ProductOrder> findAll() {
        return productOrderDao.findAll();
    }

    public void add (int unitPrice, int quantity, Command command, Product product) {

        ProductOrder myNewProductOrder = new ProductOrder(unitPrice, quantity, command, product);

        productOrderDao.add(myNewProductOrder);
    }

    public void deleteById(Integer id) {
        productOrderDao.deleteById(id);
    }

    public void update(ProductOrder productOrder) {
        productOrderDao.update(productOrder);
    }

    public ProductOrder findById(int id) {
        return productOrderDao.findById(id);
    }

}

package greta.cda.bakeryproject.service;

import greta.cda.bakeryproject.dao.ProductOrderDao;
import greta.cda.bakeryproject.entity.ProductOrder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductOrderService {

    private final ProductOrderDao productOrderDao;

    public List<ProductOrder> findAll() {
        return productOrderDao.findAll();
    }

    @Transactional
    public ProductOrder add(ProductOrder productOrder) {
        return productOrderDao.add(productOrder);
    }

    public void deleteById(String id) {
        productOrderDao.deleteById(UUID.fromString(id));
    }

    @Transactional
    public ProductOrder update(String id, ProductOrder productOrder) {
        ProductOrder productToUpdate = productOrderDao.findById(UUID.fromString(id))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("ProductOrder with id=%s not found", id)));

        productToUpdate.setProduct(productOrder.getProduct());
        productToUpdate.setQuantity(productOrder.getQuantity());
        productToUpdate.setCommand(productOrder.getCommand());
        productToUpdate.setUnitPrice(productOrder.getUnitPrice());

        return productOrderDao.update(productToUpdate);
    }

    public ProductOrder findById(String id) {
        return productOrderDao.findById(UUID.fromString(id))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("ProductOrder with id=%s not found", id)));
    }
}

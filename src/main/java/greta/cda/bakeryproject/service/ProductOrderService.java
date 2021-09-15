package greta.cda.bakeryproject.service;

import greta.cda.bakeryproject.entity.ProductOrder;
import greta.cda.bakeryproject.repository.ProductOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class ProductOrderService {
    private final ProductOrderRepository productOrderRepository;

    public List<ProductOrder> findAll() {
        return productOrderRepository.findAll();
    }

    public void create(Integer id, String name) {
        ProductOrder myNewProductOrder = new ProductOrder(id, name);
        productOrderRepository.save(myNewProductOrder);

    }

    public void deleteById(Integer id) {
        productOrderRepository.deleteById(id);
    }
}

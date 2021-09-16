package greta.cda.bakeryproject.dao.impl;

import greta.cda.bakeryproject.dao.ProductOrderDao;
import greta.cda.bakeryproject.entity.ProductOrder;
import greta.cda.bakeryproject.repository.ProductOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductOrderDaoInDb implements ProductOrderDao {
    private final ProductOrderRepository productOrderRepository;

    @Override
    public List<ProductOrder> findAll() {
        return productOrderRepository.findAll();
    }

    @Override
    public void add(ProductOrder product) {
        productOrderRepository.save(product);
    }

    @Override
    public ProductOrder findById(int id) {
        return productOrderRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(int id) {
        productOrderRepository.deleteById(id);
    }

    @Override
    public void update(ProductOrder product) {
        productOrderRepository.save(product);
    }

}

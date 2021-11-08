package greta.cda.bakeryproject.dao.impl;

import greta.cda.bakeryproject.dao.ProductOrderDao;
import greta.cda.bakeryproject.entity.ProductOrder;
import greta.cda.bakeryproject.repository.ProductOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class ProductOrderDaoInDb implements ProductOrderDao {
    private final ProductOrderRepository productOrderRepository;

    @Override
    public List<ProductOrder> findAll() {
        return productOrderRepository.findAll();
    }

    @Override
    public ProductOrder add(ProductOrder product) {
        return productOrderRepository.save(product);
    }

    @Override
    public Optional<ProductOrder> findById(UUID id) {
        return productOrderRepository.findById(id);
    }

    @Override
    public void deleteById(UUID id) {
        productOrderRepository.deleteById(id);
    }

    @Override
    public ProductOrder update(ProductOrder product) {
        return productOrderRepository.save(product);
    }

}

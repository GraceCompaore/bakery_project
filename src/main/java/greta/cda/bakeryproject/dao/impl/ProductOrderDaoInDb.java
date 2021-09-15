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
    public void add(ProductOrder productOrder) {
        productOrderRepository.save(productOrder);
    }

    @Override
    public List<ProductOrder> findAll() {
        return productOrderRepository.findAll();
    }

    @Override
    public void deleteById(int id) { productOrderRepository.deleteById(id);

    }


}

package greta.cda.bakeryproject.repository;

import greta.cda.bakeryproject.entity.ProductOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductOrderRepository extends JpaRepository<ProductOrder, Integer> {

}

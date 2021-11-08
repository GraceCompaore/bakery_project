package greta.cda.bakeryproject.repository;

import greta.cda.bakeryproject.entity.ProductOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductOrderRepository extends JpaRepository<ProductOrder, UUID> {
}

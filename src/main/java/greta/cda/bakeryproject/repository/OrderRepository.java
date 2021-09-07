package greta.cda.bakeryproject.repository;

import greta.cda.bakeryproject.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}

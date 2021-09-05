package greta.cda.bakeryproject.repository;

import greta.cda.bakeryproject.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    // List<Product> findAll();
}

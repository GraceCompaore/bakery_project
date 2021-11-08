package greta.cda.bakeryproject.repository;

import greta.cda.bakeryproject.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Category, UUID> {
}
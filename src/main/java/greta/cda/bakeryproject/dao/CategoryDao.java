package greta.cda.bakeryproject.dao;

import greta.cda.bakeryproject.entity.Category;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface CategoryDao {
    List<Category> findAll();

    Optional<Category> findById(UUID id);

    Category add(Category category);

    void deleteById(UUID id);

    Category update(Category category);

}

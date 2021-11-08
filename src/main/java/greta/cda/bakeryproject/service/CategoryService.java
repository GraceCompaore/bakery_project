package greta.cda.bakeryproject.service;


import greta.cda.bakeryproject.dao.CategoryDao;
import greta.cda.bakeryproject.entity.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryDao categoryDao;

    public List<Category> findAll() {
        return categoryDao.findAll();
    }

    @Transactional
    public Category add(Category category) {
        return categoryDao.add(category);
    }

    public void deleteById(String id) {
        categoryDao.deleteById(UUID.fromString(id));
    }

    public Category findById(String id) {
        return categoryDao.findById(UUID.fromString(id))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Category with id=%s not found", id)));
    }

    @Transactional
    public Category update(String id, Category category) {
        Category categoryToUpdate = categoryDao.findById(UUID.fromString(id))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Category with id=%s not found", id)));

        categoryToUpdate.setLabel(category.getLabel());

        return categoryDao.update(categoryToUpdate);
    }

}


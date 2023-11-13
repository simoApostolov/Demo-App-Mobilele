package bg.softuni.pathfinderDemo.service.impl;

import bg.softuni.pathfinderDemo.model.entity.Categories;
import bg.softuni.pathfinderDemo.model.entity.enums.CategoryName;
import bg.softuni.pathfinderDemo.repository.CategoryRepository;
import bg.softuni.pathfinderDemo.service.CategoryService;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Categories findCategoryByName(CategoryName categoryName) {
        return categoryRepository.findByName(categoryName).orElse(null);
    }
}

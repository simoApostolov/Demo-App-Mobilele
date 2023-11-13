package bg.softuni.pathfinderDemo.service;

import bg.softuni.pathfinderDemo.model.entity.Categories;
import bg.softuni.pathfinderDemo.model.entity.enums.CategoryName;

public interface CategoryService {


    Categories findCategoryByName(CategoryName categoryName);
}

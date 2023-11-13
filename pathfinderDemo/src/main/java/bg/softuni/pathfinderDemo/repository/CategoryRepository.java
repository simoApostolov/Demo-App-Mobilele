package bg.softuni.pathfinderDemo.repository;

import bg.softuni.pathfinderDemo.model.entity.Categories;
import bg.softuni.pathfinderDemo.model.entity.enums.CategoryName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Categories, Long> {

        Optional<Categories> findByName(CategoryName categoryName);
}

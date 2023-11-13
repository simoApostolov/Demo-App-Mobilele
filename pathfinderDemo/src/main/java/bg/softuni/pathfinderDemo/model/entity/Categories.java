package bg.softuni.pathfinderDemo.model.entity;

import bg.softuni.pathfinderDemo.model.entity.enums.CategoryName;
import jakarta.persistence.*;

@Entity
@Table(name = "categories")
public class Categories extends BaseEntity{
    @Column
    @Enumerated(EnumType.STRING)
    private CategoryName name;
    @Column(columnDefinition = "TEXT")
    private String description;

    public Categories() {
    }

    public CategoryName getName() {
        return name;
    }

    public void setName(CategoryName name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

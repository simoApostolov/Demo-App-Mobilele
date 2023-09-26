package bg.softuni.pathfinderDemo.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

@Entity
@Table(name = "roles")
public class Role extends BaseEntity{
    @Enumerated(EnumType.STRING)
    private bg.softuni.pathfinderDemo.model.entity.enums.Role name;

    public Role() {
    }

    public bg.softuni.pathfinderDemo.model.entity.enums.Role getName() {
        return name;
    }

    public void setName(bg.softuni.pathfinderDemo.model.entity.enums.Role name) {
        this.name = name;
    }
}

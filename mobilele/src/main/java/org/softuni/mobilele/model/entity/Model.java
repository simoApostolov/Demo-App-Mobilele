package org.softuni.mobilele.model.entity;

import jakarta.persistence.*;
import org.softuni.mobilele.model.entity.enums.CarCategory;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "models")
public class Model extends BaseEntity{
    @Column(nullable = false, unique = true)
    private String name;
    @Column(nullable = false,unique = true)
    @Enumerated(value = EnumType.STRING)
    private CarCategory category;
    private String imageUrl;
    @Column(nullable = false, unique = true)
    private Integer startYear;
    @Column(nullable = false,unique = true)
    private Integer endYear;
    @Column(nullable = false,unique = true)
    private LocalDateTime created;
    @Column(nullable = false,unique = true)
    private LocalDateTime modified;
    @ManyToOne
    private Brand brand;
    @OneToMany(mappedBy = "model")
    private Set<Offer> offers;

    public Model() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CarCategory getCategory() {
        return category;
    }

    public void setCategory(CarCategory category) {
        this.category = category;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getStartYear() {
        return startYear;
    }

    public void setStartYear(Integer startYear) {
        this.startYear = startYear;
    }

    public Integer getEndYear() {
        return endYear;
    }

    public void setEndYear(Integer endYear) {
        this.endYear = endYear;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Set<Offer> getOffers() {
        return offers;
    }

    public void setOffers(Set<Offer> offers) {
        this.offers = offers;
    }
}

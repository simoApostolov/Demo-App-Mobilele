package org.softuni.mobilele.model.dto;

import org.softuni.mobilele.model.entity.enums.Engine;
import org.softuni.mobilele.model.entity.enums.Transmission;

import java.math.BigDecimal;

public class OfferDetailDTO {
    private Long id;
    private String brand;
    private String model;
    private int year;
    private int mileage;
    private Engine engine;
    private Transmission transmission;
    private String imageUrl;
    private BigDecimal price;

    public OfferDetailDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    public String summary() {
        return
                brand + " " + model + ", " + year;
    }

}

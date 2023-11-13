package bg.softuni.pathfinderDemo.model.service;

import bg.softuni.pathfinderDemo.model.entity.Categories;
import bg.softuni.pathfinderDemo.model.entity.Pictures;
import bg.softuni.pathfinderDemo.model.entity.User;
import bg.softuni.pathfinderDemo.model.entity.enums.Level;
import jakarta.persistence.*;

import java.util.Set;

public class RouteServiceModel {
    private Long id;
    private String gpxCoordinates;
    private Level level;
    private String name;
    private String description;
    private User author;
    private String videoUrl;
    private Set<Pictures> pictures;
    private Set<Categories> categories;

    public RouteServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGpxCoordinates() {
        return gpxCoordinates;
    }

    public void setGpxCoordinates(String gpxCoordinates) {
        this.gpxCoordinates = gpxCoordinates;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public Set<Pictures> getPictures() {
        return pictures;
    }

    public void setPictures(Set<Pictures> pictures) {
        this.pictures = pictures;
    }

    public Set<Categories> getCategories() {
        return categories;
    }

    public void setCategories(Set<Categories> categories) {
        this.categories = categories;
    }
}

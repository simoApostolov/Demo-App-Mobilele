package bg.softuni.pathfinderDemo.model.entity;

import bg.softuni.pathfinderDemo.model.entity.enums.Level;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "routes")
public class Route extends BaseEntity{
    @Column(nullable = false, columnDefinition = "LONGTEXT")
    private String gpxCoordinates;
    @Column
    @Enumerated(EnumType.STRING)
    private Level level;
    @Column(nullable = false,unique = true)
    private String name;
    @Column(columnDefinition = "TEXT")
    private String description;
    @ManyToOne
    private User author;
    @Column
    private String videoUrl;
    @OneToMany(mappedBy = "route", fetch = FetchType.EAGER)
    private Set<Pictures> pictures;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Categories> categories;

    public Route() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Categories> getCategories() {
        return categories;
    }

    public void setCategories(Set<Categories> categories) {
        this.categories = categories;
    }

    public Set<Pictures> getPictures() {
        return pictures;
    }

    public void setPictures(Set<Pictures> pictures) {
        this.pictures = pictures;
    }
}

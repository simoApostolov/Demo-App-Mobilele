package bg.softuni.pathfinderDemo.model.view;

import bg.softuni.pathfinderDemo.model.entity.Pictures;
import bg.softuni.pathfinderDemo.model.entity.enums.Level;

import java.util.Set;

public class RouteDetailsViewModel {
    private String gpxCoordinates;
    private String description;
    private Level level;
    private String name;
    private String videoUrl;
    private Set<Pictures> pictures;

    public String getGpxCoordinates() {
        return gpxCoordinates;
    }

    public void setGpxCoordinates(String gpxCoordinates) {
        this.gpxCoordinates = gpxCoordinates;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public RouteDetailsViewModel() {
    }
}

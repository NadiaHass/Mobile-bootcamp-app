package com.example.mobilebootcamp.models;

public class Module {
    String name ;
    int startLesson;
    int endLesson;
    String imageName;
    String description;

    public Module(String name, int startLesson, int endLesson, String imageName , String description) {
        this.name = name;
        this.startLesson = startLesson;
        this.endLesson = endLesson;
        this.imageName = imageName;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStartLesson() {
        return startLesson;
    }

    public void setStartLesson(int startLesson) {
        this.startLesson = startLesson;
    }

    public int getEndLesson() {
        return endLesson;
    }

    public void setEndLesson(int endLesson) {
        this.endLesson = endLesson;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
}

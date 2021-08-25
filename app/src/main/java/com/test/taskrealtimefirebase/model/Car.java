package com.test.taskrealtimefirebase.model;

public class Car {
    private String name;
    private String description;
    private String url;

    public Car() { }

    public Car(String name, String description, String url) {
        this.name = name;
        this.description = description;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }
}
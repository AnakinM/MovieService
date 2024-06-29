package com.anikiej.movieservice.models;

import jakarta.persistence.*;

@Entity(name = "Movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Enumerated(EnumType.STRING)
    private Category category;
    private int yearReleased;
    private boolean isAvailable = false;

    public Movie() {
    }

    public Movie(String name, Category category, int yearReleased) {
        this.name = name;
        this.category = category;
        this.yearReleased = yearReleased;
    }

    public Movie(int id, String name, Category category, int year_released) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.yearReleased = year_released;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getYearReleased() {
        return yearReleased;
    }

    public void setYearReleased(int year_released) {
        this.yearReleased = year_released;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category=" + category +
                ", yearReleased=" + yearReleased +
                '}';
    }
}

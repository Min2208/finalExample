package com.codegym.model;

import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "city")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty
    private String name;

    @NumberFormat
    private int area;

    @NumberFormat
    private int population;

    @NumberFormat
    private int GDP;

    @NotEmpty
    private String description;
    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    public City(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getGDP() {
        return GDP;
    }

    public void setGDP(int GDP) {
        this.GDP = GDP;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public City(String name, int area, int population, int GDP, String description) {
        this.name = name;
        this.area = area;
        this.population = population;
        this.GDP = GDP;
        this.description = description;
    }
}

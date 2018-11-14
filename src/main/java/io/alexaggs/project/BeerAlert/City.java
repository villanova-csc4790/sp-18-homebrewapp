package io.alexaggs.project.BeerAlert;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class City {

    @Id
    private String id;
    private String name;
    private double radius;

    public City() {}

    public City(String id, String name, double radius) {
        this.id = id;
        this.name = name;
        this.radius = radius;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getRadius() {
        return radius;
    }
}

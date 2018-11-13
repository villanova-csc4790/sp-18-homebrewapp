package io.alexaggs.project.BeerAlert;

import com.google.maps.model.LatLng;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Brewery {

    @Id
    private String id;
    private String name;
    private LatLng location;

    public Brewery() {}

    public Brewery(String id, String name, LatLng location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLatLng(LatLng location) {
        this.location = location;
    }

    public String getId() { return id; }

    public String getName() { return name; }

    public LatLng getLocation() {
        return location;
    }
}
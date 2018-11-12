package io.alexaggs.project.BeerAlert;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Brewery {

    @Id
    String id;
    String name;

    public Brewery() {}

    public Brewery(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() { return id; }

    public String getName() { return name; }
}
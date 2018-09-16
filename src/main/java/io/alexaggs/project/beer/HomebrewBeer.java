package io.alexaggs.project.beer;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/*
 * Homebrewed beer entity class
 */

@Entity
public class HomebrewBeer {

    @Id
    private String beerId;
    private String beerStyle;
    private String description;
    private Boolean usedOnlineRecipe;
    private double abv, originalGravity, finalGravity, specificGravity;

    public HomebrewBeer() {}

    public HomebrewBeer(String beerId, String beerStyle, Boolean usedOnlineRecipe, String description,
                        double abv, double originalGravity, double finalGravity, double specificGravity) {

        this.beerId = beerId;
        this.beerStyle = beerStyle;
        this.usedOnlineRecipe = usedOnlineRecipe;
        this.description = description;
        this.abv = abv;
        this.originalGravity = originalGravity;
        this.finalGravity = finalGravity;
        this.specificGravity = specificGravity;
    }

    public void setBeerId(String beerId) {
        this.beerId = beerId;
    }

    public void setBeerStyle(String beerStyle) {
        this.beerStyle = beerStyle;
    }

    public void setUsedOnlineRecipe(Boolean usedOnlineRecipe) {
        this.usedOnlineRecipe = usedOnlineRecipe;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAbv(double abv) {
        this.abv = abv;
    }

    public void setOriginalGravity(double originalGravity) {
        this.originalGravity = originalGravity;
    }

    public void setFinalGravity(double finalGravity) {
        this.finalGravity = finalGravity;
    }

    public void setSpecificGravity(double specificGravity) {
        this.specificGravity = specificGravity;
    }

    public String getBeerId() {
        return beerId;
    }

    public String getBeerStyle() {
        return beerStyle;
    }

    public Boolean getUsedOnlineRecipe() {
        return usedOnlineRecipe;
    }

    public String getDescription() {
        return description;
    }

    public double getAbv() {
        return abv;
    }
    public double getOriginalGravity() {
        return originalGravity;
    }

    public double getFinalGravity() {
        return finalGravity;
    }

    public double getSpecificGravity() {
        return specificGravity;
    }
}
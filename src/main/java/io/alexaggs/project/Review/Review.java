package io.alexaggs.project.Review;

/*
 * Reviews for Commercial Beers
 */

public class Review {

    private int rating;
    private int look, smell, taste, feel;

    public Review(int rating, int look, int smell, int taste, int feel) {
        this.rating = rating;
        this.look = look;
        this.smell = smell;
        this.taste = taste;
        this.feel = feel;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setLook(int look) {
        this.look = look;
    }

    public void setSmell(int smell) {
        this.smell = smell;
    }

    public void setTaste(int taste) {
        this.taste = taste;
    }

    public void setFeel(int feel) { this.feel = feel; }

    public int getRating() {
        return rating;
    }

    public int getLook() {
        return look;
    }

    public int getSmell() {
        return smell;
    }

    public int getTaste() {
        return taste;
    }

    public int getFeel() {
        return feel;
    }
}
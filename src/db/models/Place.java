package models;

import java.util.Map;

public abstract class Place {
    // TODO:dicuss the static id ans it's importance in db
    static int id = 0;
    Map.Entry<Double, Double> location;
    private String adresse;
    private String name;
    private int rating;

    public Place(Map.Entry<Double, Double> location, String adresse, String name, int rating) {
        this.location = location;
        this.adresse = adresse;
        this.name = name;
        this.rating = rating;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

}

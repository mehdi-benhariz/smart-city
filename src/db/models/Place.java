package models;

import Utils.Pair;

public abstract class Place {

    static int id = 0;

    private String adresse;
    private String name;
    private int rating;
    private Pair location;

    public Place(Pair location, String adresse, String name, int rating) {
        this.setLocation(location);
        this.adresse = adresse;
        this.name = name;
        this.rating = rating;
    }

    public Pair getLocation() {
        return location;
    }

    public void setLocation(Pair location) {
        this.location = location;
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

    public static Pair convertStringToPair(String pair) {
        String[] Location = pair.split(" ", 1);
        Double x = Double.parseDouble(Location[0]);
        Double y = Double.parseDouble(Location[1]);
        return new Pair(x, y);
    }

    public static Object convertStringToObject(String[] row) {
        return null;
    }

}

package models;

import java.util.Map;

public class College extends Place {
    private double score;
    private String degree;

    public College(Map.Entry<Double, Double> location, String adresse, String name, int rating, double score,
            String degree) {
        super(location, adresse, name, rating);
        this.score = score;
        this.degree = degree;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }
}

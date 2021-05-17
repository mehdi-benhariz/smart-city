import java.lang.Math;
import java.util.Map;

public abstract class Place {
 Map.Entry<Double, Double> location;
 private String adresse;
 private String name;
 private int rating;
 private int id;

 public Place(float x, float y, String adresse, String name, int rating, int id) {
  location = new Map.Entry<Double, Double>() {
   final double key = x;
   final double value = y;
   @Override
   public Double getKey() {
    return null;
   }

   @Override
   public Double getValue() {
    return null;
   }

   @Override
   public Double setValue(Double value) {
    return null;
   }

  };
  this.adresse = adresse;
  this.name = name;
  this.rating = rating;
  this.id = id;
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

 public int getId() {
  return id;
 }

 public void setId(int id) {
  this.id = id;
 }

 public void CRUD(){}
}

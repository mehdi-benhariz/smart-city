package models;

import java.util.*;

import Utils.DBUtils;
import Utils.Pair;

public class Hotel extends Place implements Model {
    private boolean seaView;
    HashMap<String, Double> nightPrice = new HashMap<String, Double>();

    public Hotel(Pair<Double> location, String adresse, String name, int rating, boolean seaView,
            HashMap<String, Double> nightPrice) {
        super(location, adresse, name, rating);
        this.seaView = seaView;
        this.nightPrice = nightPrice;
    }

    public boolean isSeaView() {
        return seaView;
    }

    public void setSeaView(boolean seaView) {
        this.seaView = seaView;
    }

    public HashMap<String, Double> getNightPrice() {
        return nightPrice;
    }

    public void setNightPrice(HashMap<String, Double> nightPrice) {
        this.nightPrice = nightPrice;
    }

    public static Hotel convertStringToObject(String[] row) {
        Pair<Double> location = convertStringToPair(row[1]);
        String adresse = (row[2]);
        String name = (row[3]);
        int rating = (Integer.parseInt(row[4]));
        boolean seaView = Boolean.parseBoolean(row[5]);
        String[] tableOfNightPrices = (row[6]).split(" ");
        HashMap<String, Double> nightPrice = new HashMap<String, Double>();
        for (int j = 0; j < tableOfNightPrices.length; j += 2)
            nightPrice.put((tableOfNightPrices[j]), Double.parseDouble(tableOfNightPrices[j + 1]));

        Hotel res = new Hotel(location, adresse, name, rating, seaView, nightPrice);
        return res;
    }

    public static Vector<Hotel> getAll() {

        Vector<String[]> tableOfDB = DBUtils.getData("Hotels");
        Vector<Hotel> tableOfHotels = new Vector<Hotel>();
        for (String[] row : tableOfDB)
            tableOfHotels.add(convertStringToObject(row));

        return tableOfHotels;
    }

    public static Hotel getById(int id) {
        // res = DBUtils.getData("Hotels");
        // return Obj= res where id = id
        Vector<String[]> tableOfDB = DBUtils.getData("Hotels");
        for (String[] row : tableOfDB)
            if (Integer.parseInt((row[0])) == id)
                return convertStringToObject(row);

        return null;
    }

    public static void deleteById(int id) {

        Vector<String[]> tableOfDB = DBUtils.getData("Hotels");
        for (String[] row : tableOfDB)
            // id is in the first case
            if (Integer.parseInt((row[0])) == id) {
                tableOfDB.remove(row);
                break;
            }

        DBUtils.saveData("Hotels", tableOfDB, false);
    }

    public static void update(int id, Hotel newHotel) {
        Vector<String[]> tableOfDB = DBUtils.getData("Hotels");
        for (String[] row : tableOfDB) {
            // id is in the first case
            if (Integer.parseInt((row[0])) == id) {
                row[1] = String.valueOf(
                        (newHotel.getLocation().getX()) + " " + String.valueOf((newHotel.getLocation()).getY()));
                row[2] = newHotel.getAdresse();
                row[3] = newHotel.getName();
                row[4] = String.valueOf(newHotel.getRating());
                row[5] = String.valueOf(newHotel.isSeaView());
                String nightPriceString = "";
                HashMap<String, Double> nightPrice = newHotel.getNightPrice();
                for (String j : nightPrice.keySet()) {
                    nightPriceString.concat(j);
                    nightPriceString.concat(" ");
                    nightPriceString.concat(String.valueOf(nightPrice.get(j)));
                }
                row[6] = nightPriceString;
                break;
            }
        }
        DBUtils.saveData("Hotels", tableOfDB, false);
    }

    @Override
    public void save() {
        // create a String[] from "this" data
        // write to db;

        Vector<String[]> tableOfDB = new Vector<String[]>();
        String[] row = new String[7];

        row[1] = String.valueOf((getLocation().getX())) + " " + String.valueOf((getLocation()).getY());
        row[2] = getAdresse();
        row[3] = getName();
        row[4] = String.valueOf(getRating());
        row[5] = String.valueOf(isSeaView());

        HashMap<String, Double> nightPrice = getNightPrice();
        for (String key : nightPrice.keySet())
            row[6] += key + " " + String.valueOf(nightPrice.get(key));

        tableOfDB.add(row);
        DBUtils.saveData("Hotels", tableOfDB, true);
    }

    @Override
    public String toString() {
        String aux = "";
        for (String i : nightPrice.keySet())
            aux = aux + ("Room type : " + i + "\n" + "Price: " + nightPrice.get(i));

        return super.toString() + "Sea View : " + seaView + "night prices" + aux;
    }
}

package models;

import java.util.Vector;

import Utils.DBUtils;
import Utils.Pair;

//add to all models  / toSTtring
public class College extends Place implements Model {
    private double score;
    private String degree;

    public College(Pair<Double> location, String adresse, String name, int rating, double score, String degree) {
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

    public static College convertStringToObject(String[] row) {
        Pair<Double> location = convertStringToPair(row[0]);
        String adresse = (row[1]);
        String name = (row[2]);
        int rating = (Integer.parseInt(row[3]));
        Double score = Double.parseDouble((row[4]));
        String degree = (row[5]);
        return new College(location, adresse, name, rating, score, degree);

    }

    public static Vector<College> getAll() {

        Vector<String[]> tableOfDB = DBUtils.getData("Colleges");
        Vector<College> tableOfColleges = new Vector<College>();
        for (String[] row : tableOfDB)
            tableOfColleges.add(convertStringToObject(row));

        return tableOfColleges;
    }

    public static College getById(int id) {

        Vector<String[]> tableOfDB = DBUtils.getData("college");
        for (String[] row : tableOfDB)

            if (Integer.parseInt((row[0])) == id)
                return convertStringToObject(row);

        return null;
    }

    public static void deleteById(int id) {
        Vector<String[]> tableOfDB = DBUtils.getData("Colleges");
        for (String[] row : tableOfDB)
            // id is in the first case
            if (Integer.parseInt((row[0])) == id) {
                tableOfDB.remove(row);
                break;
            }
        DBUtils.saveData("Colleges", tableOfDB, false);

    }

    public static void update(int id, College newCollege) {
        // res = DBUtils.getData("Colleges");
        // update from res
        // DBUtils.saveData("Colleges",res,false)
        Vector<String[]> tableOfDB = DBUtils.getData("Colleges");
        for (String[] row : tableOfDB)
            // id is in the first case
            if (Integer.parseInt((row[0])) == id) {
                row[1] = String.valueOf(
                        (newCollege.getLocation().getX()) + " " + String.valueOf((newCollege.getLocation()).getY()));
                row[2] = newCollege.getAdresse();
                row[3] = newCollege.getName();
                row[4] = String.valueOf(newCollege.getRating());
                row[5] = String.valueOf(newCollege.getScore());
                row[6] = newCollege.getDegree();
                break;
            }

        DBUtils.saveData("Colleges", tableOfDB, false);
    }

    @Override
    public void save() {

        Vector<String[]> tableOfDB = new Vector<String[]>();
        String[] row = new String[7];

        row[1] = String.valueOf((getLocation().getX())) + " " + String.valueOf((getLocation()).getY());
        row[2] = getAdresse();
        row[3] = getName();
        row[4] = String.valueOf(getRating());
        row[5] = String.valueOf(getScore());
        row[6] = getDegree();
        tableOfDB.add(row);
        DBUtils.saveData("Colleges", tableOfDB, true);
    }

    @Override
    public String toString() {
        return super.toString() + "Score : " + score + "Degree : " + degree;
    }
}

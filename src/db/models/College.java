package models;

import java.util.Vector;

import Utils.DBUtils;
import Utils.Pair;

public class College extends Place implements Model {
    private double score;
    private String degree;

    public College(Pair location, String adresse, String name, int rating, double score, String degree) {
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

    public static Vector<College> getAll() {

        Vector<String[]> tableOfDB = DBUtils.getData("Colleges");
        Vector<College> tableOfColleges = new Vector<College>();
        for (int i = 0; i < tableOfDB.size(); i++) {
            Pair location = convertStringToPair(tableOfDB.get(i)[0]);
            String adresse = (tableOfDB.get(i)[1]);
            String name = (tableOfDB.get(i)[2]);
            int rating = (Integer.parseInt(tableOfDB.get(i)[3]));
            Double score = Double.parseDouble((tableOfDB.get(i)[4]));
            String degree = (tableOfDB.get(i)[5]);

            tableOfColleges.add(new College(location, adresse, name, rating, score, degree));
        }
        return tableOfColleges;
    }

    public static College getById(int id) {
        // res = DBUtils.getData("Colleges");
        // return Obj= res where id = id
        Vector<String[]> tableOfDB = DBUtils.getData("college");
        for (int i = 0; i < tableOfDB.size(); i++) {
            // id is in the first case
            if (Integer.parseInt((tableOfDB.get(i)[0])) == id) {
                String[] Location = (tableOfDB.get(i)[1]).split(" ", 1);
                // to change to method changeStringToPair
                College res = new College(new Pair(Double.parseDouble(Location[0]), Double.parseDouble(Location[1])),
                        (tableOfDB.get(i)[2]), (tableOfDB.get(i)[3]), (Integer.parseInt(tableOfDB.get(i)[4])),
                        Double.parseDouble((tableOfDB.get(i)[5])), (tableOfDB.get(i)[6]));
                return res;
            }
        }
        return null;
    }

    public static void deleteById(int id) {
        // res = DBUtils.getData("Colleges");
        // delete from res
        // DBUtils.saveData("Colleges",res,false)
        Vector<String[]> tableOfDB = DBUtils.getData("Colleges");
        for (int i = 0; i < tableOfDB.size(); i++) {
            // id is in the first case
            if (Integer.parseInt((tableOfDB.get(i)[0])) == id) {
                tableOfDB.remove(i);
                break;
            }
        }
        DBUtils.saveData("Colleges", tableOfDB, false);
    }

    public static void update(int id, College newCollege) {
        // res = DBUtils.getData("Colleges");
        // update from res
        // DBUtils.saveData("Colleges",res,false)
        Vector<String[]> tableOfDB = DBUtils.getData("Colleges");
        for (int i = 0; i < tableOfDB.size(); i++) {
            // id is in the first case
            if (Integer.parseInt((tableOfDB.get(i)[0])) == id) {
                tableOfDB.get(i)[1] = String.valueOf(
                        (newCollege.getLocation().getX()) + " " + String.valueOf((newCollege.getLocation()).getY()));
                tableOfDB.get(i)[2] = newCollege.getAdresse();
                tableOfDB.get(i)[3] = newCollege.getName();
                tableOfDB.get(i)[4] = String.valueOf(newCollege.getRating());
                tableOfDB.get(i)[5] = String.valueOf(newCollege.getScore());
                tableOfDB.get(i)[6] = newCollege.getDegree();
                break;
            }
        }
        DBUtils.saveData("Colleges", tableOfDB, false);
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
        row[5] = String.valueOf(getScore());
        row[6] = getDegree();
        tableOfDB.add(row);
        DBUtils.saveData("Colleges", tableOfDB, true);
    }
}

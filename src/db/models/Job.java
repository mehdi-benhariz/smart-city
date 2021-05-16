package models;

import java.util.Vector;

import Utils.DBUtils;

public class Job implements Model {
    private String name;

    private String description;
    private String degree;
    private int id;

    public Job(String name, String description, String degree, int id) {
        this.setName(name);
        this.setDescription(description);
        this.setDegree(degree);
        this.setId(id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public static Job convertStringToObject(String[] row) {
        int id = Integer.parseInt(row[0]);
        String name = row[1];
        String description = row[2];
        String degree = row[3];
        return new Job(name, description, degree, id);

    }

    public static Vector<Job> getAll() {

        Vector<String[]> tableOfDB = DBUtils.getData("Jobs");
        Vector<Job> tableOfJobs = new Vector<Job>();
        for (String[] row : tableOfDB)
            tableOfJobs.add(convertStringToObject(row));

        return tableOfJobs;
    }

    public static Job getById(int id) {

        Vector<String[]> tableOfDB = DBUtils.getData("Jobs");
        for (String[] row : tableOfDB)
            if (Integer.parseInt((row[0])) == id) {
                Job res = convertStringToObject(row);
                return res;
            }

        return null;
    }

    public static void deleteById(int id) {

        Vector<String[]> tableOfDB = DBUtils.getData("Jobs");
        for (String[] row : tableOfDB)
            if (Integer.parseInt((row[0])) == id) {
                tableOfDB.remove(row);
                break;

            }
        DBUtils.saveData("Jobs", tableOfDB, false);
    }

    public static void update(int id, Job newjob) {

        Vector<String[]> tableOfDB = DBUtils.getData("Jobs");
        for (String[] row : tableOfDB)

            if (Integer.parseInt((row[0])) == id) {
                row[1] = newjob.getName();
                row[2] = newjob.getDescription();
                row[3] = newjob.getDegree();
                break;
            }

        DBUtils.saveData("Jobs", tableOfDB, false);
    }

    @Override
    public void save() {
        Vector<String[]> tableOfDB = new Vector<String[]>();
        String[] row = new String[7];
        row[0] = String.valueOf(getId());
        row[1] = getName();
        row[2] = getDescription();
        row[3] = getDegree();
        tableOfDB.add(row);

        DBUtils.saveData("Jobs", tableOfDB, true);
    }

}

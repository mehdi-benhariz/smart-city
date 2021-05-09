package models;

import java.util.Vector;

import Utils.DBUtils;

public class Job implements Model {
    private String name;

    private String description;
    private String degree;

    public Job(String name, String description, String degree) {
        this.setName(name);
        this.setDescription(description);
        this.setDegree(degree);
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

    // TODO add 5 methods : getAll / getById(int id)/deleteById (Int id) /update(int
    // id, Job newJob) and save()
    public static Vector<Job> getAll() {

        Vector<String[]> tableOfDB = DBUtils.getData("Jobs");
        Vector<Job> tableOfJobs = new Vector<Job>();
        for (int i = 0; i < tableOfDB.size(); i++)
            tableOfJobs.add(new Job(tableOfDB.get(i)[1], tableOfDB.get(i)[2], tableOfDB.get(i)[3]));

        return tableOfJobs;
    }

    public static Job getById(int id) {
        // res = DBUtils.getData("Jobs");
        // return Obj= res where id = id
        Vector<String[]> tableOfDB = DBUtils.getData("Jobs");
        for (int i = 0; i < tableOfDB.size(); i++) {
            // id is in the first case
            if (Integer.parseInt((tableOfDB.get(i)[0])) == id) {

                // 0-id 1-name 2-description 3-degree
                Job res = new Job(tableOfDB.get(i)[1], tableOfDB.get(i)[2], tableOfDB.get(i)[3]);
                return res;
            }
        }
        return null;
    }

    public static void deleteById(int id) {
        // res = DBUtils.getData("Jobs");
        // delete from res
        // DBUtils.saveData("Jobs",res,false)
        Vector<String[]> tableOfDB = DBUtils.getData("Jobs");
        for (int i = 0; i < tableOfDB.size(); i++) {
            // id is in the first case
            if (Integer.parseInt((tableOfDB.get(i)[0])) == id) {
                tableOfDB.remove(i);
                break;
            }
        }
        DBUtils.saveData("Jobs", tableOfDB, false);
    }

    public static void update(int id, Job newjob) {
        // res = DBUtils.getData("Jobs");
        // update from res
        // DBUtils.saveData("Jobs",res,false)
        Vector<String[]> tableOfDB = DBUtils.getData("Jobs");
        for (int i = 0; i < tableOfDB.size(); i++) {
            // id is in the first case
            if (Integer.parseInt((tableOfDB.get(i)[0])) == id) {
                tableOfDB.get(i)[1] = newjob.getName();
                tableOfDB.get(i)[2] = newjob.getDescription();
                tableOfDB.get(i)[3] = newjob.getDegree();
                break;
            }
        }
        DBUtils.saveData("college", tableOfDB, false);
    }

    @Override
    public void save() {
        Vector<String[]> tableOfDB = new Vector<String[]>();
        String[] row = new String[7];
        row[1] = getName();
        row[2] = getDescription();
        row[3] = getDegree();
        tableOfDB.add(row);

        DBUtils.saveData("Jobs", tableOfDB, true);
    }

}

package models;

import java.util.*;

import Utils.DBUtils;
import Utils.Pair;

public class Company extends Place implements Model {

    private List<Job> jobs = new ArrayList<Job>() {
        {
            add(new Job("developer", "description", "CS", 1));
            add(new Job("QA", "description", "CS", 2));
            add(new Job("Engineer", "description", "CS", 3));
        }
    };

    public Company(Pair location, String adresse, String name, int rating, List<Job> jobs) {
        super(location, adresse, name, rating);
        setJobs(jobs);
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

    public static Company convertStringToObject(String[] row) {
        Pair location = convertStringToPair(row[1]);
        String adresse = row[2];
        String name = row[3];
        int rating = (Integer.parseInt(row[4]));
        String jobIdList = (row[5]);
        String[] tableOfJobId = jobIdList.split(" ");
        List<Job> jobList = new ArrayList<Job>();
        for (int j = 0; j < tableOfJobId.length; j++)
            jobList.add(Job.getById(Integer.parseInt(tableOfJobId[j])));
        Company res = new Company(location, adresse, name, rating, jobList);
        return res;
    }

    public static Vector<Company> getAll() {

        Vector<String[]> tableOfDB = DBUtils.getData("Companies");
        Vector<Company> tableOfCompanies = new Vector<Company>();
        for (String[] row : tableOfDB)
            tableOfCompanies.add(convertStringToObject(row));

        return tableOfCompanies;
    }

    public static Company getById(int id) {
        // res = DBUtils.getData("Companies");
        // return Obj= res where id = id
        Vector<String[]> tableOfDB = DBUtils.getData("Companies");
        for (String[] row : tableOfDB)
            if (Integer.parseInt((row[0])) == id) {
                Company res = convertStringToObject(row);
                return res;
            }

        return null;
    }

    public static void deleteById(int id) {

        Vector<String[]> tableOfDB = DBUtils.getData("Companies");
        for (String[] row : tableOfDB)
            // id is in the first case
            if (Integer.parseInt((row[0])) == id) {
                tableOfDB.remove(row);
                break;
            }

        DBUtils.saveData("Companies", tableOfDB, false);
    }

    public static void update(int id, Company newCompany) {

        Vector<String[]> tableOfDB = DBUtils.getData("Companies");
        for (String[] row : tableOfDB) {
            // id is in the first case
            if (Integer.parseInt((row[0])) == id) {
                row[1] = String.valueOf(
                        (newCompany.getLocation().getX()) + " " + String.valueOf((newCompany.getLocation()).getY()));
                row[2] = newCompany.getAdresse();
                row[3] = newCompany.getName();
                row[4] = String.valueOf(newCompany.getRating());
                List<Job> jobs = newCompany.getJobs();
                for (Job job : jobs)
                    row[5] += job.getId() + " ";

                break;
            }
        }
        DBUtils.saveData("Companies", tableOfDB, false);
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
        List<Job> jobs = getJobs();
        for (Job job : jobs)
            row[5] += job.getId() + " ";

        tableOfDB.add(row);
        DBUtils.saveData("Companies", tableOfDB, true);
    }

}

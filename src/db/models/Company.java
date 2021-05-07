package models;

import java.util.*;

public class Company extends Place {
    // first approach : this requires another
    private List<Job> jobs = new ArrayList<Job>() {
        {
            add(new Job("developer", "description", "CS"));
            add(new Job("QA", "description", "CS"));
            add(new Job("Engineer", "description", "CS"));
        }
    };

    // second approach

    public Company(Map.Entry<Double, Double> location, String adresse, String name, int rating) {
        super(location, adresse, name, rating);
    }

    public List<Job> getJobs() {
        return jobs;
    }

}

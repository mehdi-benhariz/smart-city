package models;

import java.util.*;

import Utils.Pair;

public class Company extends Place {

    private List<Job> jobs = new ArrayList<Job>() {
        {
            add(new Job("developer", "description", "CS"));
            add(new Job("QA", "description", "CS"));
            add(new Job("Engineer", "description", "CS"));
        }
    };

    public Company(Pair location, String adresse, String name, int rating) {
        super(location, adresse, name, rating);
    }

    public List<Job> getJobs() {
        return jobs;
    }

}

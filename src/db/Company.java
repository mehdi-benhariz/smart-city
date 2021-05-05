
import java.util.ArrayList;
import java.util.List;

import java.util.Map;

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
    /* private Map<String, String> Jobs = new Map<String, String>(); */

    public Company(Map.Entry<String, Integer> location, String adresse, String name, float ratings) {
        /* super(location, adresse, name, ratings); */
    }

    public List<Job> getJobs() {
        return jobs;
    }

}

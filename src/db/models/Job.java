package models;

public class Job {
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

}

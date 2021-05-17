public final class College extends Place{
    private double score;
    private String degree;

    public College(float x, float y, String adresse, String name, int rating, int id, double score, String degree) {
        super(x, y, adresse, name, rating, id);
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
}

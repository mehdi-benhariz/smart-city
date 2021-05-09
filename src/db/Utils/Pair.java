package Utils;

public class Pair {
    private Double x;

    public Pair(Double x, Double y) {
        this.x = x;
        this.y = y;
    }

    private Double y;

    public Double getX() {
        return x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public void setX(Double x) {
        this.x = x;
    }

}

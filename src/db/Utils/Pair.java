package Utils;

public class Pair<P> {
    private P x;
    private P y;

    public Pair(P x, P y) {
        this.x = x;
        this.y = y;
    }

    public P getX() {
        return x;
    }

    public P getY() {
        return y;
    }

    public void setY(P y) {
        this.y = y;
    }

    public void setX(P x) {
        this.x = x;
    }

}

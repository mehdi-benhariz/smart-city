import java.util.*;
public final class Hotel extends Place {
    private boolean seaView;
    HashMap<Integer,Double> nightPrice = new HashMap<Integer,Double>();

    public Hotel(float x, float y, String adresse, String name, int rating, int id, boolean seaView, HashMap<Integer, Double> nightPrice) {
        super(x, y, adresse, name, rating, id);
        this.seaView = seaView;
        this.nightPrice = nightPrice;
    }

    public boolean isSeaView() {
        return seaView;
    }

    public void setSeaView(boolean seaView) {
        this.seaView = seaView;
    }

    public HashMap<Integer, Double> getNightPrice() {
        return nightPrice;
    }

    public void setNightPrice(HashMap<Integer, Double> nightPrice) {
        this.nightPrice = nightPrice;
    }
}

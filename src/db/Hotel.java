import java.util.*;

public class Hotel extends Place {
    private boolean seaView;
    HashMap<Integer, Double> nightPrice = new HashMap<Integer, Double>();

    public Hotel(Map.Entry<Double, Double> location, String adresse, String name, int rating, boolean seaView,
            HashMap<Integer, Double> nightPrice) {
        super(location, adresse, name, rating);
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

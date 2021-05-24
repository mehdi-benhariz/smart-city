package views;

import models.Hotel;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Vector;

import Context.Context;
import Utils.Pair;

public class HotelScreenForm extends Screen {

    public HotelScreenForm(String screenName) {
        super(screenName, null);
    }

    @Override
    public void display() {
        this.displayScreenName();
    }

    public Hotel RecommandedHotel() {
        Scanner input = new Scanner(System.in);
        System.out.println("Specify the Hotel Rating you're looking for:");
        int rating = input.nextInt();
        System.out.println("Specify if you'd like a Cityview or Beachview:");
        String answer = input.nextLine();
        Boolean seaview = true;
        if (answer == "Cityview")
            seaview = false;
        System.out.println("Specify the Area:");
        String area = input.nextLine();
        Pair<Double> coord = new Pair<Double>(5.0, 6.0);
        HashMap<String, Double> prices = new HashMap<String, Double>();

        Hotel recommandation = new Hotel(coord, area, " ", rating, seaview, prices);
        return recommandation;

    }

    @Override
    public void build(Context context) {
        this.display();
        Vector<Hotel> resualts = context.recommander.recommand(RecommandedHotel());
        for (Hotel hotel : resualts) {
            System.out.println("=> " + hotel.getName());
        }
        context.navigator.push(context, "/categories");
    }
}
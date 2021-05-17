package views;

import models.College;

import java.util.Scanner;
import java.util.Vector;

import Context.Context;
import Utils.Pair;

public class CollegeScreenForm extends Screen {
    public CollegeScreenForm(String screenName, String[] options) {
        super(screenName, options);
    }

    protected College RecommandedCollege() {
        Scanner input = new Scanner(System.in);
        System.out.println("Specify the College Rating you're looking for:");
        int rating = input.nextInt();
        System.out.println("Specify the College Degree you're wishing to pursue:");
        String degree = input.nextLine();
        System.out.println("Specify the college Score you're looking for:");
        int collegescore = input.nextInt();
        System.out.println("Specify the Area:");
        String area = input.nextLine();

        Pair<Double> coord = new Pair<Double>(5.0, 6.0);

        College recommandation = new College(coord, area, " ", rating, collegescore, degree);
        return recommandation;
    }

    /*--------NOT TESTED--------*/
    @Override
    public void build(Context context) {
        this.display();
        Vector<College> resualts = context.recommander.recommand(RecommandedCollege());
        for (College college : resualts) {
            System.out.println("=> " + college.getName());
        }
    }
}

package views;

import java.util.Scanner;

/**
 * SelectCategory
 */
public class SelectCategory extends Screen {

    public SelectCategory(String screenName, String[] options) {
        super(screenName, options);
    }

    public String handelInput() {
        Scanner input = new Scanner(System.in);
        System.out.print("[choice] : ");
        int choice = input.nextInt();

        // choices
        if (choice == 1) {
            System.out.println("Education");
        }
        if (choice == 2)
            System.out.println("accommodation");

        if (choice == 3)
            System.out.println("work");

        if (choice == 0) {
            return "exit";
        }
        // stay on the same screen
        return "mainScreen";

    }

}
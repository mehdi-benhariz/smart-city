package views;

import java.util.Scanner;

import models.User;

public class Welcome_screen extends Screen {

    public Welcome_screen(String screenName, String[] options) {
        super(screenName, options);
    }

    public String handelInput() {
        Scanner input = new Scanner(System.in);
        System.out.print("[choice] : ");
        int choice = input.nextInt();

        // choices
        if (choice == 1) {
            Boolean isAuth = User.auth();
            if (isAuth)
                return "categoryScreen";
            return "mainScreen";
        }
        if (choice == 2) {
            System.out.println("registration");
            return "mainScreen";
        }
        if (choice == 0) {
            return "exit";
        }
        // stay on the same screen
        return "mainScreen";

    }
}

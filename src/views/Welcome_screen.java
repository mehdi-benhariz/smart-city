package views;

import java.util.Scanner;

import models.User;

public class Welcome_screen {
    public static void on() {
        while (true) {
            System.out.println("______________________________");
            System.out.println("Chose your action:");
            System.out.println("______________________________");

            System.out.println("[1] login");
            System.out.println("[2] registration");
            System.out.println("[3] exit");

            Scanner input = new Scanner(System.in);
            System.out.print("[choice] : ");
            int choice = input.nextInt();
            if (choice == 1) {
                Boolean isAuth = User.auth();
                if (isAuth)
                    System.out.println("Selecte category screen");
            }
            if (choice == 3) {
                input.close();
                System.exit(0);
            }
        }

    }
}

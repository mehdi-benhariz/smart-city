package user_interaction;

import java.util.Scanner;

import services.administration.User;

public class Welcome_screen {
    public static void on() {
        Boolean takeFirstAction = false;
        while(!takeFirstAction){
            System.out.println("Chose your action:");
            System.out.println("[1] login");
            System.out.println("[2] registration");
            System.out.println("[3] exit");

        
        Scanner input = new Scanner(System.in);
        System.out.println("[choice] : ");
        int choice = input.nextInt();
        if (choice == 1) {
            takeFirstAction = User.auth();
        }
        if (choice == 2) {
            takeFirstAction = User.auth();
    }
        }
        
    }
}

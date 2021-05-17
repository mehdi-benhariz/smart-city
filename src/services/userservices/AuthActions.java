package services.userservices;

import java.util.Scanner;

import models.User;

public class AuthActions {
    /*
     * Get user input and return User object if Exist
     */

    public static User loginUser(String password, String username) {
        User user = User.auth(password, username);
        return user;
    }

    /*
     * Get user input and return User object if user created successfullly
     */

    public static User registeUser() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your name:");
        String name = input.next();
        System.out.println("Enter your email:");
        String email = input.next();
        System.out.println("Enter your age:");
        int age = input.nextInt();
        System.out.println("Enter your password:");
        String pwd = input.next();
        System.out.println("confirm your password:");
        String confirmpwd = input.next();

        while (!confirmpwd.equals(pwd)) {
            System.out.println("[error] Password and confirme password don't match, please try again");
            System.out.println("Enter your password:");
            pwd = input.next();
            System.out.println("confirm your password:");
            confirmpwd = input.next();
        }
        // input.close();

        return User.register(age, email, name, pwd);
    }
}

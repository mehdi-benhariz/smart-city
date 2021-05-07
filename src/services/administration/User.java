package services.administration;

import java.util.Scanner;

public abstract class User {
    private int age;
    private String email;
    private int id;
    private String name;
    private String pwd;

    public User(int id, String name, int age, String email, String pwd) {
        this.age = age;
        this.email = email;
        this.id = id;
        this.name = name;
        this.pwd = pwd;
    }

    public static Boolean auth() {
        // public static User auth() {

        try {
            Scanner input = new Scanner(System.in);
            System.out.println("Log in ");
            System.out.println("Username");
            String username = input.nextLine();
            System.out.println("password");
            String password = input.nextLine();

            // TODO: check if a user with this credential exists in the DB
            // ORMUser return User object if exist else NULL
            // user = ORMUser.find(username, password)
            // if(user)
            if (username.equals("ahmed") && password.equals("password")) {

                System.out.println("your are logged");
                // return user;
                return true;
            }
            System.out.println("login failed");
            return false;
            // return NULL;
        } catch (Exception e) {
            return false;
            // return NULL;
        }
    }

    public static void register() {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name:");
        String name = sc.next();
        System.out.println("Enter your email:");
        String email = sc.next();
        System.out.println("Enter your age:");
        int age = sc.nextInt();
        System.out.println("Enter your password:");
        String pwd = sc.next();
        System.out.println("confirm your password:");
        String confirmpwd = sc.next();

        while (confirmpwd != pwd) {

            System.out.println("write your pwd again");

            System.out.println("Enter your password:");
            pwd = sc.next();
            System.out.println("confirm your password:");
            confirmpwd = sc.next();

        }

    }
}
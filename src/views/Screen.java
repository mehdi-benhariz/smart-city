package views;

import java.util.Scanner;

public class Screen {
    protected String screenName;
    protected String[] options;

    public Screen(String screenName, String[] options) {
        this.screenName = screenName;
        this.options = options;
    }

    public void display() {
        System.out.println("______________________________");
        // System.out.println("Which section you are looking for.");
        System.out.println(this.screenName);
        System.out.println("______________________________");
        for (int i = 0; i < this.options.length; i++) {
            System.out.println("[" + (i + 1) + "] " + this.options[i]);
        }
        System.out.println("[0] exit ");
    }

    public String handelInput() {
        Scanner input = new Scanner(System.in);
        System.out.print("[choice] : ");
        int choice = input.nextInt();
        System.out.println("=>> " + choice);
        // choices
        if (choice == 0)
            return "exit";

        // stay on the same screen
        return "mainScreen";

    }
}

package views;

import java.util.Scanner;

import Context.Context;

public class Screen {
    protected String screenName;
    protected String[] options;

    public Screen(String screenName, String[] options) {
        this.screenName = screenName;
        this.options = options;
    }

    protected void displayScreenName() {
        System.out.println("______________________________");
        // System.out.println("Which section you are looking for.");
        System.out.println(this.screenName);
        System.out.println("______________________________");
    }

    protected void display() {
        this.displayScreenName();
        for (int i = 0; i < this.options.length; i++) {
            System.out.println("[" + (i + 1) + "] " + this.options[i]);
        }
        System.out.println("[0] exit ");
    }

    protected String handelInput() {
        Scanner input = new Scanner(System.in);
        System.out.print("[choice] : ");
        int choice = input.nextInt();
        System.out.println("Your choice : " + choice);
        input.close();
        return "/home";
    }

    public void build(Context context) {
        this.display();
        context.navigator.push(context, this.handelInput());
    }

}

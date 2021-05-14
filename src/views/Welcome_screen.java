package views;

import java.util.Scanner;

import Context.Context;

public class Welcome_screen extends Screen {

    public Welcome_screen(String screenName, String[] options) {
        super(screenName, options);
    }

    public String handelInput() {
        Scanner input = new Scanner(System.in);
        System.out.print("[choice] : ");
        int choice = input.nextInt();
        // input.close();
        // choices
        if (choice == 1) {
            return "/login";
        }
        if (choice == 2) {
            return "/register";
        }
        if (choice == 0) {
            return "/exit";
        }
        // stay on the same screen
        return "/home";
    }

    @Override
    public void build(Context context) {
        this.display();
        context.navigator.push(context, this.handelInput());
    }
}

package views;

import java.util.Scanner;

import Context.Context;

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
        // input.close();
        // choices
        if (choice == 1)
            return "/education";

        if (choice == 2)
            return "/accommodation";

        if (choice == 3)
            return "/work";

        if (choice == 0)
            return "/exit";

        // stay on the main screen
        return "/mainScreen";

    }

    @Override
    public void build(Context context) {
        this.display();
        context.navigator.push(context, this.handelInput());

    }

}
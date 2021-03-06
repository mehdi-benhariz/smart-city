package views;

import java.util.Scanner;

import Context.Context;
import models.User;
import services.userservices.AuthActions;

public class LoginScreen extends Screen {

    public LoginScreen(String screenName) {
        super(screenName, null);
    }

    @Override
    public void display() {
        this.displayScreenName();
    }

    /*
     * Get user input and return User object if Exist
     */

    @Override
    public void build(Context context) {
        this.display();

        Scanner input = new Scanner(System.in);
        System.out.print("Username : ");
        String username = input.nextLine();
        System.out.print("password : ");
        String password = input.nextLine();
        // input.close();
        User user = AuthActions.loginUser(password, username);
        context.setUser(user);
        if (user != null)
            context.navigator.push(context, "/categories");
        else {
            System.out.println("[error] Login Faild");
            context.navigator.pop();
        }
    }

}

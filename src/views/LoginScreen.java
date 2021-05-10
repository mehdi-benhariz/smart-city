package views;

import Context.Context;

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
        context.setUser(AuthActions.loginUser());
    }
}

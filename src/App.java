import java.util.HashMap;

import Context.Context;
import views.Exit;
import views.Screen;
import views.SelectCategory;
import views.LoginScreen;

import views.Welcome_screen;

public class App {
    public static void main(String[] args) throws Exception {
        final String[] mainOptions = { "login", "registration" };
        final String[] CategoryOptions = { "Education", "accommodation", "work", "retrun" };

        HashMap<String, Screen> routes = new HashMap<String, Screen>();

        routes.put("/home", new Welcome_screen("Chose your action:", mainOptions));
        // routes.put("/login", new LoginScreen("Please Login to Continue !"));
        routes.put("/categories",
                new SelectCategory("Welecome to smart city, what are you looking for :", CategoryOptions));
        routes.put("/exit", new Exit());

        Context context = new Context(routes);
        context.init("/home");
        while (true) {
            context.build();
        }

    }

}

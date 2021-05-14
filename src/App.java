import java.util.HashMap;

import Context.Context;
import models.User;
import views.Exit;
import views.Screen;
import views.SelectCategory;
import views.WelcomeScreen;
import views.LoginScreen;

public class App {
    public static void main(String[] args) throws Exception {
        final String[] mainOptions = { "login", "registration" };
        final String[] CategoryOptions = { "Education", "accommodation", "work", "retrun" };

        HashMap<String, Screen> routes = new HashMap<String, Screen>();

        routes.put("/home", new WelcomeScreen("Chose your action:", mainOptions));
        routes.put("/login", new LoginScreen("Please Login to Continue !"));
        routes.put("/categories",
                new SelectCategory("Welecome to smart city, what are you looking for :", CategoryOptions));
        // routes.put("/form",new
        // FormScreen
        // ); //
        // routes.put("/result", new ResultScreen());

        routes.put("/exit", new Exit());

        Context context = new Context(routes);
        context.init("/home");
        while (true) {
            context.build();
        }

    }

}

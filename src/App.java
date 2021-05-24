import java.util.HashMap;

import Context.Context;

import services.Recommand;
//import services.api.HotelAPI;
import views.Exit;
import views.HotelScreenForm;
import views.Screen;
import views.SelectCategory;
import views.WelcomeScreen;
import views.LoginScreen;

public class App {
        public static void main(String[] args) throws Exception {

                final String[] mainOptions = { "login", "registration" };
                final String[] CategoryOptions = { "Education", "accommodation", "work", "retrun" };
                HashMap<String, Screen> routes = new HashMap<String, Screen>();
                // HashMap<String, Recommand> recommander = new HashMap<String, Recommand>();

                routes.put("/home", new WelcomeScreen("Chose your action:", mainOptions));
                routes.put("/login", new LoginScreen("Please Login to Continue !"));
                routes.put("/categories", new SelectCategory("Welecome to smart city, what are you looking for :",
                                CategoryOptions));
                routes.put("/accommodation", new HotelScreenForm("Enter the things you like"));
                // routes.put("/result", new ResultScreen());

                routes.put("/exit", new Exit());
                // Create one sigle recommander instance and use its method for every
                // recommandation object
                Recommand recommander = new Recommand();
                Context context = new Context(routes, recommander);
                context.init("/home");
                while (true) {
                        context.build();
                }

        }

}

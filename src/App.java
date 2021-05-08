import views.Screen;
import views.SelectCategory;
import views.Welcome_screen;

public class App {
    public static void main(String[] args) throws Exception {
        final String[] mainOptions = { "login", "registration" };
        final String[] CategoryOptions = { "Education", "accommodation", "work", "retrun" };

        final Screen[] screenNav = new Screen[2];

        screenNav[0] = new Welcome_screen("Chose your action:", mainOptions);
        screenNav[1] = new SelectCategory("Welecome to smart city, what are you looking for :", CategoryOptions);

        String currentScreen = "mainScreen";

        // TODO: Add InputMismatchException

        while (true) {
            System.out.println("==> " + currentScreen);
            if (currentScreen == "mainScreen") {
                screenNav[0].display();
                currentScreen = screenNav[0].handelInput();
            } else if (currentScreen == "categoryScreen") {
                screenNav[1].display();
                currentScreen = screenNav[1].handelInput();
            } else if (currentScreen == "exit")
                System.exit(0);
            else {
                System.out.println("invalid command");
            }
        }

    }

}

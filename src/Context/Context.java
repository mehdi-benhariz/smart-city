package Context;

import java.util.HashMap;

import models.User;
import navigation.Navigator;
import views.Screen;

public class Context {
    private HashMap<String, Screen> routes = new HashMap<String, Screen>();
    public Navigator navigator = new Navigator();
    private Screen activeScreen;
    private User user = null;

    public Context(HashMap<String, Screen> routes) {
        this.routes = routes;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public HashMap<String, Screen> getRoutes() {
        return routes;
    }

    public void setRoutes(HashMap<String, Screen> routes) {
        this.routes = routes;
    }

    public Screen match(String route) {
        return this.routes.get(route);
    }

    public void init(String homeRoute) {
        this.activeScreen = this.navigator.push(this.routes.get(homeRoute));
    }

    public void setActiveScreen(Screen screen) {
        this.activeScreen = this.navigator.push(screen);
    }

    public void build() {
        this.activeScreen.build(this);
    }
}

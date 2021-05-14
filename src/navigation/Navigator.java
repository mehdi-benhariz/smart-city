package navigation;

import java.util.Stack;

import Context.Context;
import views.Screen;

public class Navigator {

    private Stack<Screen> navStack = new Stack<Screen>();

    public Navigator() {
    }

    public void push(Context context, String route) {
        Screen screen = context.match(route);
        context.setActiveScreen(screen);

    }

    public Screen push(Screen screen) {
        navStack.push(screen);
        return navStack.peek();
    }

    public Screen pop() {
        return navStack.pop();
    }

}

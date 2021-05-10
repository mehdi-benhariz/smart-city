package views;

import Context.Context;

/**
 * Exit
 */
public class Exit extends Screen {
    public Exit() {
        super("Exit", null);
    }

    @Override
    public void build(Context context) {
        System.exit(0);
    }

}
package services;

import java.util.Vector;

public abstract class Service {
    Vector<Integer> scoreTable = new Vector<Integer>();

    public abstract int getScore(Object obj);

    public static void suggest() {
    }
}

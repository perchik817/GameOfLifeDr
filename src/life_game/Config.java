package life_game;

import life_game.Status;

import java.awt.*;

public class Config {
    public static final int size = 10;
    public static final int width = 100;
    public static final int height = 70;
    public static final int SLEEPMS = 200;

    public static Color getColor(Status status){
        switch (status){
            default:
            case NONE: return Color.BLACK;
            case BORN: return Color.DARK_GRAY;
            case LIVE: return Color.WHITE;
            case DIED: return Color.RED;
        }
    }

}

package com.minhkakart.ninjaschool.game.configurations;

import java.awt.*;

public class GlobalConfig {
    public static final String GAME_TITLE = "Ninja School";
    public static final int GAME_SCALE = 2;
    public static final int ORIGINAL_WIDTH = 400;
    public static final int ORIGINAL_HEIGHT = 240;
    public static final int GAME_WIDTH = ORIGINAL_WIDTH * GAME_SCALE;
    public static final int GAME_HEIGHT = ORIGINAL_HEIGHT * GAME_SCALE;
    public static final int GAME_FPS = 100;
    public static final Shape GAME_SHAPE = new Rectangle(0, 0, GAME_WIDTH, GAME_HEIGHT);
}

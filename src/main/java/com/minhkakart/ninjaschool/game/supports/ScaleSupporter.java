package com.minhkakart.ninjaschool.game.supports;

import com.minhkakart.ninjaschool.game.configurations.GlobalConfig;

import java.awt.*;

public class ScaleSupporter {
    public static Point getUnscaledPoint(Point point) {
        return new Point(point.x / GlobalConfig.GAME_SCALE, point.y / GlobalConfig.GAME_SCALE);
    }
}

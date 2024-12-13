package com.minhkakart.ninjaschool.game.models;

import java.awt.*;

import static com.minhkakart.ninjaschool.game.configurations.GlobalConfig.ORIGINAL_HEIGHT;
import static com.minhkakart.ninjaschool.game.configurations.GlobalConfig.ORIGINAL_WIDTH;
import static com.minhkakart.ninjaschool.game.models.MapAssetPart.MAP_PART_HEIGHT;
import static com.minhkakart.ninjaschool.game.models.MapAssetPart.MAP_PART_WIDTH;

public class Camera {
    private final int minX = 2 * MAP_PART_WIDTH;
    private final int minY = 2 * MAP_PART_HEIGHT;
    private final Rectangle viewPort = new Rectangle(minX, minY, ORIGINAL_WIDTH, ORIGINAL_HEIGHT);

    private int maxX;
    private int maxY;


    public Camera() {
        this.maxX = minX;
        this.maxY = minY;
    }

    public void setViewArea(int width, int height) {
        this.maxX = width - minX * 2;
        this.maxY = height - minY * 2;
    }

    public void move(int dx, int dy) {
        viewPort.translate(dx, dy);
        if (viewPort.x < minX) {
            viewPort.x = minX;
        } else if (viewPort.x > maxX) {
            viewPort.x = maxX;
        }
        if (viewPort.y < minY) {
            viewPort.y = minY;
        } else if (viewPort.y > maxY) {
            viewPort.y = maxY;
        }
    }

    public boolean isViewable(Point point) {
        return viewPort.contains(point);
    }

    public boolean isViewable(Rectangle rectangle) {
        return viewPort.intersects(rectangle);
    }
}

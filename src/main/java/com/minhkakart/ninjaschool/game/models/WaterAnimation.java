package com.minhkakart.ninjaschool.game.models;

import com.minhkakart.ninjaschool.game.interfaces.Drawable;
import com.minhkakart.ninjaschool.game.managers.ResourceManager;

import javax.swing.*;
import java.awt.*;

public class WaterAnimation implements Drawable {
    private boolean firstIndex = true;
    private final Timer timer;
    private final Point[] positions;

    public WaterAnimation(Point[] positions, Point startPoint) {
        for (Point point : this.positions = positions) {
            point.translate(startPoint.x, startPoint.y);
        }
        this.timer = new Timer(400, e -> firstIndex = !firstIndex);
        timer.start();
    }

    public void move(int dx, int dy) {
        for (Point position : positions) {
            position.translate(dx, dy);
        }
    }

    public void destroy() {
        timer.stop();
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        for (Point position : positions) {
            if (firstIndex) {
                graphics2D.drawImage(ResourceManager.getWaterSlide(), position.x, position.y, position.x + MapAssetPart.MAP_PART_WIDTH, position.y + MapAssetPart.MAP_PART_HEIGHT, 0, 0, MapAssetPart.MAP_PART_WIDTH, MapAssetPart.MAP_PART_HEIGHT, null);
            } else {
                graphics2D.drawImage(ResourceManager.getWaterSlide(), position.x, position.y, position.x + MapAssetPart.MAP_PART_WIDTH, position.y + MapAssetPart.MAP_PART_HEIGHT, 0, MapAssetPart.MAP_PART_HEIGHT, MapAssetPart.MAP_PART_WIDTH, MapAssetPart.MAP_PART_HEIGHT * 2, null);
            }
        }
    }
}

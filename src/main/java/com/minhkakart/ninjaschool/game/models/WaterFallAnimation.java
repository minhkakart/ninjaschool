package com.minhkakart.ninjaschool.game.models;

import com.minhkakart.ninjaschool.game.interfaces.Drawable;
import com.minhkakart.ninjaschool.game.managers.ResourceManager;

import javax.swing.*;
import java.awt.*;

public class WaterFallAnimation implements Drawable {
    private int index = 0;
    private final Timer timer;
    private final Point[] topPositions;
    private final Point[] bodyPositions;

    public WaterFallAnimation(Point[] topPositions, Point[] bodyPositions, Point startPoint) {
        for (Point point : this.topPositions = topPositions) {
            point.translate(startPoint.x, startPoint.y);
        }
        for (Point point : this.bodyPositions = bodyPositions) {
            point.translate(startPoint.x, startPoint.y);
        }
        this.timer = new Timer(100, e -> {
            if (index + 1 == 4) {
                index = 0;
            } else {
                index++;
            }
        });
        timer.start();
    }
    
    public void destroy() {
        timer.stop();
    }

    public void move(int dx, int dy) {
        for (Point topPosition : topPositions) {
            topPosition.translate(dx, dy);
        }
        for (Point bodyPosition : bodyPositions) {
            bodyPosition.translate(dx, dy);
        }
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        for (Point topPosition : topPositions) {
            graphics2D.drawImage(ResourceManager.getTopWaterFall(), topPosition.x, topPosition.y, topPosition.x + MapAssetPart.MAP_PART_WIDTH, topPosition.y + MapAssetPart.MAP_PART_HEIGHT, 0, index * MapAssetPart.MAP_PART_HEIGHT, MapAssetPart.MAP_PART_WIDTH, (index + 1) * MapAssetPart.MAP_PART_HEIGHT, null);
        }
        for (Point bodyPosition : bodyPositions) {
            graphics2D.drawImage(ResourceManager.getWaterFall(), bodyPosition.x, bodyPosition.y, bodyPosition.x + MapAssetPart.MAP_PART_WIDTH, bodyPosition.y + MapAssetPart.MAP_PART_HEIGHT, 0, index * MapAssetPart.MAP_PART_HEIGHT, MapAssetPart.MAP_PART_WIDTH, (index + 1) * MapAssetPart.MAP_PART_HEIGHT, null);
        }
    }
}

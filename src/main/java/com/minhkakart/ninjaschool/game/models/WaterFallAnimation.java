package com.minhkakart.ninjaschool.game.models;

import com.minhkakart.ninjaschool.game.interfaces.Drawable;
import com.minhkakart.ninjaschool.game.managers.ResourceManager;

import javax.swing.*;
import java.awt.*;

public class WaterFallAnimation implements Drawable {
    private int index = 0;
    private final Timer timer;
    private final Point topPosition;
    private final Point[] bodyPositions;

    public WaterFallAnimation(Point topPosition, Point[] bodyPositions) {
        this.topPosition = topPosition;
        this.bodyPositions = bodyPositions;
        this.timer = new Timer(100, e -> {
            if (index + 1 == 4) {
                index = 0;
            } else {
                index++;
            }
        });
        timer.start();
    }

    public void move(int dx, int dy) {
        topPosition.translate(dx, dy);
        for (Point bodyPosition : bodyPositions) {
            bodyPosition.translate(dx, dy);
        }
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        graphics2D.drawImage(ResourceManager.getTopWaterFall(), topPosition.x, topPosition.y, topPosition.x + MapAssetPart.PART_WIDTH, topPosition.y + MapAssetPart.PART_HEIGHT, 0, index * MapAssetPart.PART_HEIGHT, MapAssetPart.PART_WIDTH, (index + 1) * MapAssetPart.PART_HEIGHT, null);
        for (Point bodyPosition : bodyPositions) {
            graphics2D.drawImage(ResourceManager.getWaterFall(), bodyPosition.x, bodyPosition.y, bodyPosition.x + MapAssetPart.PART_WIDTH, bodyPosition.y + MapAssetPart.PART_HEIGHT, 0, index * MapAssetPart.PART_HEIGHT, MapAssetPart.PART_WIDTH, (index + 1) * MapAssetPart.PART_HEIGHT, null);
        }
    }
}

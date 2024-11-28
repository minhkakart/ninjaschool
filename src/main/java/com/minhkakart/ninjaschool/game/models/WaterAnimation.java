package com.minhkakart.ninjaschool.game.models;

import com.minhkakart.ninjaschool.game.interfaces.Drawable;
import com.minhkakart.ninjaschool.game.managers.ResourceManager;

import javax.swing.*;
import java.awt.*;

public class WaterAnimation implements Drawable {
    private boolean firstIndex = true;
    private final Timer timer;
    private final Point position;
    private final int range;

    public WaterAnimation(Point position, int range) {
        this.position = position;
        this.range = range;
        this.timer = new Timer(400, e -> {
            firstIndex = !firstIndex;
        });
        timer.start();
    }

    public void move(int dx, int dy) {
        position.translate(dx, dy);
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        for (int i = 0; i < range; i++) {
            if (firstIndex) {
                graphics2D.drawImage(ResourceManager.getWaterSlide(), position.x + i * MapAssetPart.PART_WIDTH, position.y, position.x + MapAssetPart.PART_WIDTH + i * MapAssetPart.PART_WIDTH, position.y + MapAssetPart.PART_HEIGHT, 0, 0, MapAssetPart.PART_WIDTH, MapAssetPart.PART_HEIGHT, null);
            } else {
                graphics2D.drawImage(ResourceManager.getWaterSlide(), position.x + i * MapAssetPart.PART_WIDTH, position.y, position.x + MapAssetPart.PART_WIDTH + i * MapAssetPart.PART_WIDTH, position.y + MapAssetPart.PART_HEIGHT, 0, MapAssetPart.PART_HEIGHT, MapAssetPart.PART_WIDTH, MapAssetPart.PART_HEIGHT * 2, null);
            }
        }
    }
}

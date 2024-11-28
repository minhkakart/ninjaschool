package com.minhkakart.ninjaschool.game.enums;

import com.minhkakart.ninjaschool.game.configurations.GlobalConfig;
import com.minhkakart.ninjaschool.game.managers.ResourceManager;

import java.awt.*;

public enum BackgroundPlace {
    VILLAGE(new Color(32, 195, 245), true,
            new ImagePart(ResourceManager.getMapBackground(40), new Point(0, GlobalConfig.ORIGINAL_HEIGHT - 64 - 35 - 38 - 61 + 30 + 10)),
            new ImagePart(ResourceManager.getMapBackground(33), new Point(0, GlobalConfig.ORIGINAL_HEIGHT - 64 - 35 - 38 + 6 + 10)),
            new ImagePart(ResourceManager.getMapBackground(23), new Point(0, GlobalConfig.ORIGINAL_HEIGHT - 64 - 35 + 10)),
            new ImagePart(ResourceManager.getMapBackground(9), new Point(0, GlobalConfig.ORIGINAL_HEIGHT - 64))
    ),
    COUNTRY(new Color(86, 171, 238), true,
            new ImagePart(ResourceManager.getMapBackground(37), new Point(0, GlobalConfig.ORIGINAL_HEIGHT - 59 - 29 - 31 - 70 + 20)),
            new ImagePart(ResourceManager.getMapBackground(28), new Point(0, GlobalConfig.ORIGINAL_HEIGHT - 59 - 29 - 31)),
            new ImagePart(ResourceManager.getMapBackground(16), new Point(0, GlobalConfig.ORIGINAL_HEIGHT - 59 - 29)),
            new ImagePart(ResourceManager.getMapBackground(0), new Point(0, GlobalConfig.ORIGINAL_HEIGHT - 59))
    );

    private final Color backgroundColor;
    private final boolean sliding;
    private final ImagePart[] imageParts;

    BackgroundPlace(Color backgroundColor, boolean sliding, ImagePart... imageParts) {
        this.backgroundColor = backgroundColor;
        this.sliding = sliding;
        this.imageParts = imageParts;
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public boolean isSliding() {
        return sliding;
    }

    public ImagePart[] getImageParts() {
        return imageParts;
    }

    public static class ImagePart {
        private final Image image;
        private final Point position;

        public ImagePart(Image image, Point position) {
            this.image = image;
            this.position = position;
        }

        public Image getImage() {
            return image;
        }

        public Point getPosition() {
            return (Point) position.clone();
        }
    }
}

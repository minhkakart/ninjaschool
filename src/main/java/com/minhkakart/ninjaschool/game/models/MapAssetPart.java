package com.minhkakart.ninjaschool.game.models;

import com.minhkakart.ninjaschool.game.managers.ResourceManager;

import java.awt.*;
import java.awt.image.BufferedImage;

public class MapAssetPart {
    public static final int PART_WIDTH = 24;
    public static final int PART_HEIGHT = 24;
    
    public static BufferedImage GetPartImage(int assetId) {
        int partNumber = assetId % 1000;
        int assetNumber = (assetId - partNumber) / 1000;
        BufferedImage src = null;
        
        switch (assetNumber) {
            case 1:
                src = ResourceManager.getMapAsset(0);
                break;
            case 2:
                src = ResourceManager.getMapAsset(1);
                break;
            case 3:
                src = ResourceManager.getMapAsset(2);
                break;
            case 4:
                src = ResourceManager.getMapAsset(3);
                break;
        }
        
        if (src == null) {
            return null;
        }

        if ((assetNumber == 1 && partNumber > 120) || (assetNumber == 2 && partNumber > 141) || (assetNumber == 3 && partNumber > 143) || (assetNumber == 4 && partNumber > 103)) {
            return null;
        }
        
        return src.getSubimage(0, (partNumber - 1) * PART_HEIGHT, PART_WIDTH, PART_HEIGHT);
    }
}

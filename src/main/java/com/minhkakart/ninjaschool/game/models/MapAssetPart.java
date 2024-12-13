package com.minhkakart.ninjaschool.game.models;

import com.minhkakart.ninjaschool.game.managers.ResourceManager;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

public class MapAssetPart {
    public static final int MAP_PART_WIDTH = 24;
    public static final int MAP_PART_HEIGHT = 24;
    
    private static final Map<Integer, BufferedImage> PART_CACHE = new HashMap<>();
    
    public static BufferedImage GetPartImage(int assetId) {
        if (PART_CACHE.containsKey(assetId)) {
            return PART_CACHE.get(assetId);
        }

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
        
        PART_CACHE.put(assetId, src.getSubimage(0, (partNumber - 1) * MAP_PART_HEIGHT, MAP_PART_WIDTH, MAP_PART_HEIGHT));
        
        return PART_CACHE.get(assetId);
    }
}

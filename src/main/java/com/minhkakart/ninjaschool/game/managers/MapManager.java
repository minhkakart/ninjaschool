package com.minhkakart.ninjaschool.game.managers;

import com.minhkakart.ninjaschool.game.enums.MapInfo;

public class MapManager {
    private static MapInfo currentMapInfo = null;
    
    public static MapInfo getCurrentMapId() {
        return currentMapInfo;
    }
    
    public static void setCurrentMap(MapInfo mapInfo) {
        currentMapInfo = mapInfo;
        BackgroundManager.setBackgroundPlace(mapInfo.getBackgroundPlace());
    }
    
}

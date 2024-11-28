package com.minhkakart.ninjaschool.game.enums;

public enum LayerDepth {
    BACKGROUND(-1, "Background"),
    DEFAULT(0, "Default"),
    START(2, "Start"),
    MAP_VIEW(3, "Map View"),
    WORLD_MAP(100, "World Map"),
    ;

    private final int depth;
    private final String name;

    LayerDepth(int depth, String name) {
        this.depth = depth;
        this.name = name;
    }

    public int getDepth() {
        return depth;
    }
    
    public String getName() {
        return name;
    }


    @Override
    public String toString() {
        return super.toString().replace("_", " ");
    }
}

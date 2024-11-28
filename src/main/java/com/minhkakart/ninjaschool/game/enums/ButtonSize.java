package com.minhkakart.ninjaschool.game.enums;

public enum ButtonSize {
    START_BUTTON(150, 35),
    SMALL_BUTTON(70, 22),
    ;
    
    private final int width;
    private final int height;
    
    ButtonSize(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}

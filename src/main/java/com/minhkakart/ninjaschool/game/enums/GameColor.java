package com.minhkakart.ninjaschool.game.enums;

import java.awt.*;

public enum GameColor {
    BUTTON_PRIMARY(new Color(60, 20, 0)),
    BUTTON_PRIMARY_CLICKED(new Color(146, 50, 0)),
    ;
    
    private final Color color;
    
    GameColor(Color color) {
        this.color = color;
    }
    
    public Color getColor() {
        return color;
    }
}

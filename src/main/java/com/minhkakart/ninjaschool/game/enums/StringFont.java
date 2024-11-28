package com.minhkakart.ninjaschool.game.enums;

public enum StringFont {
    TAHOMA_7_BLACK("/game/font/tahoma_7.png", FontType.FONT_7A),
    TAHOMA_7_BLUE("/game/font/tahoma_7_blue.png", FontType.FONT_7A),
    TAHOMA_7_BLUE1("/game/font/tahoma_7_blue1.png", FontType.FONT_7A),
    TAHOMA_7_GREEN("/game/font/tahoma_7_green.png", FontType.FONT_7A),
    TAHOMA_7_GRAY("/game/font/tahoma_7_grey.png", FontType.FONT_7A),
    TAHOMA_7_RED("/game/font/tahoma_7_red.png", FontType.FONT_7A),
    TAHOMA_7_WHITE("/game/font/tahoma_7_white.png", FontType.FONT_7A),
    TAHOMA_7_YELLOW("/game/font/tahoma_7_yellow.png", FontType.FONT_7A),
    TAHOMA_7B_BLUE("/game/font/tahoma_7b_blue.png", FontType.FONT_7B),
    TAHOMA_7B_GREEN("/game/font/tahoma_7b_green.png", FontType.FONT_7B),
    TAHOMA_7B_PURPLE("/game/font/tahoma_7b_purple.png", FontType.FONT_7B),
    TAHOMA_7B_RED("/game/font/tahoma_7b_red.png", FontType.FONT_7B),
    TAHOMA_7B_WHITE("/game/font/tahoma_7b_white.png", FontType.FONT_7B),
    TAHOMA_7B_YELLOW("/game/font/tahoma_7b_yellow.png", FontType.FONT_7B),
    TAHOMA_8B("/game/font/tahoma_8b.png", FontType.FONT_8B);

    private final String path;
    private final FontType fontType;
    
    StringFont(String path, FontType fontType) {
        this.path = path;
        this.fontType = fontType;
    }
    
    public String getPath() {
        return path;
    }
    
    public FontType getFontType() {
        return fontType;
    }
}
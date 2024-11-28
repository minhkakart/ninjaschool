package com.minhkakart.ninjaschool.game.supports;

import com.minhkakart.ninjaschool.game.converters.StringConverter;
import com.minhkakart.ninjaschool.game.enums.StringFont;

import java.awt.*;

public class TextSupporter {
    /**
     * Get the bound of a string with a specific font
     *
     * @param text
     * @param font
     * @return int[] {width, height}
     */
    public static int[] getStringBound(String text, StringFont font) {
        int width = 0;
        int maxHeight = 0;
        for (int i = 0; i < text.length(); i++) {
            Rectangle bound = StringConverter.getCharRect(text.charAt(i), font.getFontType());
            width += bound.width;
            if (bound.height > maxHeight) {
                maxHeight = bound.height;
            }
        }
        
        return new int[]{width, maxHeight};
    }

    public static String trimFull(String s){
        return s.trim().replaceAll("\\s+", " ");
    }
}

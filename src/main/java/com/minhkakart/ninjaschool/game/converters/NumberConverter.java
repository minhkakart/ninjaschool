package com.minhkakart.ninjaschool.game.converters;

import com.minhkakart.ninjaschool.game.enums.NumberFontColor;
import com.minhkakart.ninjaschool.game.managers.ResourceManager;

import java.awt.*;
import java.awt.image.BufferedImage;

public class NumberConverter {
    private static final Rectangle[] NUMBER_RECT = {
            new Rectangle(0, 1, 5, 8), // 0
            new Rectangle(0, 9, 3, 8), // 1
            new Rectangle(0, 17, 5, 8), // 2
            new Rectangle(0, 25, 5, 8), // 3
            new Rectangle(0, 33, 5, 8), // 4
            new Rectangle(0, 41, 5, 8), // 5
            new Rectangle(0, 49, 5, 8), // 6
            new Rectangle(0, 57, 5, 8), // 7
            new Rectangle(0, 65, 5, 8), // 8
            new Rectangle(0, 73, 5, 8), // 9
            new Rectangle(0, 81, 5, 8), // +
            new Rectangle(0, 88, 5, 8), // -
    };

    public static BufferedImage[] convertNumberToImageArray(long number, NumberFontColor numberFontColor) {
        boolean isNegative = number < 0;
        String numberString = String.valueOf(Math.abs(number));
        BufferedImage[] bufferedImages = new BufferedImage[numberString.length() + 1];
        if (isNegative) {
            bufferedImages[0] = ResourceManager.getNumberFont(numberFontColor).getSubimage(NUMBER_RECT[11].x, NUMBER_RECT[11].y, NUMBER_RECT[11].width, NUMBER_RECT[11].height);
        } else {
            bufferedImages[0] = ResourceManager.getNumberFont(numberFontColor).getSubimage(NUMBER_RECT[10].x, NUMBER_RECT[10].y, NUMBER_RECT[10].width, NUMBER_RECT[10].height);
        }
        for (int i = 1; i <= numberString.length(); i++) {
            int digit = Integer.parseInt(String.valueOf(numberString.charAt(i-1)));
            bufferedImages[i] = ResourceManager.getNumberFont(numberFontColor).getSubimage(NUMBER_RECT[digit].x, NUMBER_RECT[digit].y, NUMBER_RECT[digit].width, NUMBER_RECT[digit].height);
        }
        return bufferedImages;
    }
}

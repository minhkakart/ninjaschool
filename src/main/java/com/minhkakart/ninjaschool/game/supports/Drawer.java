package com.minhkakart.ninjaschool.game.supports;

import com.minhkakart.ninjaschool.game.converters.NumberConverter;
import com.minhkakart.ninjaschool.game.converters.StringConverter;
import com.minhkakart.ninjaschool.game.enums.NumberFontColor;
import com.minhkakart.ninjaschool.game.enums.StringFont;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;

@SuppressWarnings("unused")
public class Drawer {

    /**
     * Draw a number in single line
     *
     * @param number          to draw
     * @param x               position
     * @param y               position
     * @param graphics2D      context to draw
     * @param numberFontColor color of number
     */
    public static void drawInteger(long number, int x, int y, Graphics2D graphics2D, NumberFontColor numberFontColor) {
        BufferedImage[] images = NumberConverter.convertNumberToImageArray(number, numberFontColor);
        int offset = 0;
        for (BufferedImage image : images) {
            graphics2D.drawImage(image, x + offset, y, null);
            offset += image.getWidth();
        }
    }

    public static void drawIntegerRaw(long number, int x, int y, Graphics2D graphics2D, NumberFontColor numberFontColor) {
        BufferedImage[] images = NumberConverter.convertNumberToImageArray(number, numberFontColor);
        if (number >= 0){
            images = Arrays.copyOfRange(images, 1, images.length);
        }
        int offset = 0;
        for (BufferedImage image : images) {
            graphics2D.drawImage(image, x + offset, y, null);
            offset += image.getWidth();
        }
    }

    /**
     * Draw a string in single line
     *
     * @param string     to draw
     * @param x          position
     * @param y          position
     * @param graphics2D context to draw
     */
    public static void drawString(String string, int x, int y, Graphics2D graphics2D, StringFont stringFont) {
        BufferedImage[] images = StringConverter.convertStringToImageArray(string, stringFont);
        int offset = 0;
        for (BufferedImage image : images) {
            graphics2D.drawImage(image, x + offset, y, null);
            offset += image.getWidth();
        }
    }

    /**
     * Draw a string in multi line with specified area width
     *
     * @param string     to draw
     * @param area       to draw
     * @param graphics2D context to draw
     * @param stringFont font of string
     */
    public static void drawString(String string, Rectangle area, Graphics2D graphics2D, StringFont stringFont) {
        ArrayList<BufferedImage> space = Arrays.stream(StringConverter.convertStringToImageArray(" ", stringFont)).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        String[] wordsString = string.trim().split(" ");
        ArrayList<ArrayList<BufferedImage>> words = new ArrayList<>(wordsString.length);
        for (String word : wordsString) {
            words.add(Arrays.stream(StringConverter.convertStringToImageArray(word, stringFont)).collect(ArrayList::new, ArrayList::add, ArrayList::addAll));
            words.add(space);
        }

        int width = area.width;
        int line = 0;
        int lineWidth = 0;
        int offsetLine = 0;

        for (ArrayList<BufferedImage> word : words) {
            int wordWidth = 0;
            // Calculate width of word
            for (BufferedImage image : word) {
                wordWidth += image.getWidth();
            }
            if (lineWidth + wordWidth > width) {
                line++;
                lineWidth = 0;
                offsetLine = 0;
            }
            for (BufferedImage image : word) {
                lineWidth += image.getWidth();
                graphics2D.drawImage(image, area.x + offsetLine, area.y + line * image.getHeight(), null);
                offsetLine += image.getWidth();
            }
        }
    }

    /**
     * Draw single line string centered in specified area
     *
     * @param string     to draw
     * @param area       to draw
     * @param graphics2D context to draw
     * @param stringFont font of string
     */
    public static void drawStringCentered(String string, Rectangle area, Graphics2D graphics2D, StringFont stringFont) {
        int[] bound = TextSupporter.getStringBound(string, stringFont);
        if (bound[0] > area.width) {
            drawString(string, area, graphics2D, stringFont);
        } else {
            int x = area.x + (area.width - bound[0]) / 2;
            int y = area.y + (area.height - bound[1]) / 2;
            drawString(string, x, y, graphics2D, stringFont);
        }
    }

    /**
     * Draw shadow string
     *
     * @param string     to draw
     * @param x          position
     * @param y          position
     * @param graphics2D context to draw
     * @param stringFont font of string
     */
    public static void drawShadowString(String string, int x, int y, Graphics2D graphics2D, StringFont stringFont) {
        drawString(string, x + 1, y + 1, graphics2D, StringFont.TAHOMA_7_GRAY);
        drawString(string, x, y, graphics2D, stringFont);
    }

    /**
     * Draw shadow string multi line
     *
     * @param string     to draw
     * @param area       to draw
     * @param graphics2D context to draw
     * @param stringFont font of string
     */
    public static void drawShadowString(String string, Rectangle area, Graphics2D graphics2D, StringFont stringFont) {
        drawString(string, area.x + 1, area.y + 1, graphics2D, StringFont.TAHOMA_7_GRAY);
        drawString(string, area, graphics2D, stringFont);
    }

    /**
     * Draw shadow string centered
     *
     * @param string     to draw
     * @param area       to draw
     * @param graphics2D context to draw
     * @param stringFont font of string
     */
    public static void drawShadowStringCentered(String string, Rectangle area, Graphics2D graphics2D, StringFont stringFont) {
        drawStringCentered(string, new Rectangle(area.x + 1, area.y + 1, area.width, area.height), graphics2D, StringFont.TAHOMA_7_GRAY);
        drawStringCentered(string, area, graphics2D, stringFont);
    }

}

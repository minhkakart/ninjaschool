package com.minhkakart.ninjaschool.game.managers;

import com.minhkakart.ninjaschool.Main;
import com.minhkakart.ninjaschool.game.enums.BorderIndex;
import com.minhkakart.ninjaschool.game.enums.NumberFontColor;
import com.minhkakart.ninjaschool.game.enums.StringFont;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

@SuppressWarnings({"unused"})
public class ResourceManager {
    private static final BufferedImage[] CORE_IMAGE = new BufferedImage[5];
    private static final BufferedImage[] MAP_BACKGROUND = new BufferedImage[50];
    private static final BufferedImage[] MAP_VIEW = new BufferedImage[4];
    private static final BufferedImage[] MINI_MAP = new BufferedImage[4];
    private static final BufferedImage[] NUMBER_FONT = new BufferedImage[5];
    private static final BufferedImage[] STRING_FONT = new BufferedImage[15];
    private static final BufferedImage[] BORDERS = new BufferedImage[9];
    private static final BufferedImage[] SPINNER = new BufferedImage[3];
    private static final BufferedImage[] SMALL_BUTTON = new BufferedImage[2];
    private static BufferedImage WORLD_MAP = null;
    private static BufferedImage WORLD_MAP_POINTER = null;
    private static BufferedImage STAR = null;
    private static final BufferedImage[] MAP_ASSETS = new BufferedImage[4];
    private static BufferedImage WATER_SLIDE = null;
    private static BufferedImage TOP_WATER_FALL = null;
    private static BufferedImage WATER_FALL = null;

    public static InputStream getInputStream(String path) {
        return Main.class.getResourceAsStream(path);
    }

    public static BufferedImage loadImage(String path) {
        InputStream inputStream;
        inputStream = getInputStream(path);
        assert inputStream != null;
        try {
            return ImageIO.read(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static BufferedImage getCoreImage(int index) {
        // Load core game resources
        if (CORE_IMAGE[index] == null) {
            String[] coreImages = new String[]{"/game/img/Big0.png", "/game/img/Big1.png", "/game/img/Big2.png", "/game/img/Big3.png", "/game/img/Big4.png"};
            CORE_IMAGE[index] = loadImage(coreImages[index]);
            System.out.println("Loaded core images " + index);
        }
        return CORE_IMAGE[index];
    }

    public static BufferedImage getMapBackground(int index) {
        if (MAP_BACKGROUND[index] == null) {
            String[] bgNames = new String[]{"/game/bg/bg00.png", "/game/bg/bg01.png", "/game/bg/bg010.png", "/game/bg/bg011.png", "/game/bg/bg013.png", "/game/bg/bg014.png", "/game/bg/bg015.png", "/game/bg/bg016.png", "/game/bg/bg02.png", "/game/bg/bg03.png", "/game/bg/bg04.png", "/game/bg/bg05.png", "/game/bg/bg06.png", "/game/bg/bg07.png", "/game/bg/bg08.png", "/game/bg/bg09.png", "/game/bg/bg10.png", "/game/bg/bg11.png", "/game/bg/bg113.png", "/game/bg/bg114.png", "/game/bg/bg115.png", "/game/bg/bg116.png", "/game/bg/bg12.png", "/game/bg/bg13.png", "/game/bg/bg15.png", "/game/bg/bg16.png", "/game/bg/bg17.png", "/game/bg/bg18.png", "/game/bg/bg20.png", "/game/bg/bg21.png", "/game/bg/bg214.png", "/game/bg/bg216.png", "/game/bg/bg22.png", "/game/bg/bg23.png", "/game/bg/bg25.png", "/game/bg/bg26.png", "/game/bg/bg28.png", "/game/bg/bg30.png", "/game/bg/bg31.png", "/game/bg/bg314.png", "/game/bg/bg32.png", "/game/bg/bg33.png", "/game/bg/bg34.png", "/game/bg/bg35.png", "/game/bg/bg37.png", "/game/bg/bg38.png", "/game/bg/bg39.png", "/game/bg/cl0.png", "/game/bg/cl1.png", "/game/bg/cl2.png", "/game/bg/cl3.png", "/game/bg/moon.png", "/game/bg/sun.png"};
        /* Load map background
        InputStream inputStream;
        MAP_BACKGROUND = loadImages(bgNames);
        MAP_BACKGROUND = new BufferedImage[bgNames.length];
        for (int i = 0; i < bgNames.length; i++) {
            inputStream = getInputStream(bgNames[i]);
            assert inputStream != null;
            MAP_BACKGROUND[i] = ImageIO.read(inputStream);
            System.out.println("Loaded map background " + bgNames[i].replace("/game/bg/", "") + ", index: " + i);
        }
        */
            MAP_BACKGROUND[index] = loadImage(bgNames[index]);
            System.out.println("Loaded map backgrounds " + index);
        }
        return MAP_BACKGROUND[index];
    }

    public static BufferedImage getMapView(int index) {
        // Load map view
        if (MAP_VIEW[index] == null) {
            String[] mapViews = new String[]{"/game/mapassets/1.png", "/game/mapassets/2.png", "/game/mapassets/3.png", "/game/mapassets/4.png"};
            MAP_VIEW[index] = loadImage(mapViews[index]);
            System.out.println("Loaded map views " + index);
        }
        return MAP_VIEW[index];
    }

    public static BufferedImage getMiniMap(int index) {
        // Load mini map
        if (MINI_MAP[index] == null) {
            String[] miniMaps = new String[]{"/game/t/mini_1.png", "/game/t/mini_2.png", "/game/t/mini_3.png", "/game/t/mini_4.png"};
            MINI_MAP[index] = loadImage(miniMaps[index]);
            System.out.println("Loaded mini maps " + index);
        }
        return MINI_MAP[index];
    }

    public static BufferedImage getNumberFont(NumberFontColor index) {
        // Load number font
        if (NUMBER_FONT[index.ordinal()] == null) {
            String[] numberFonts = new String[]{"/game/font/number_green.png", "/game/font/number_orange.png", "/game/font/number_red.png", "/game/font/number_white.png", "/game/font/number_yellow.png"};
            NUMBER_FONT[index.ordinal()] = loadImage(numberFonts[index.ordinal()]);
            System.out.println("Loaded number fonts " + index);
        }
        return NUMBER_FONT[index.ordinal()];
    }

    public static BufferedImage getStringFont(StringFont index) {
        // Load string font
        if (STRING_FONT[index.ordinal()] == null) {
            String[] stringFonts = Arrays.stream(StringFont.values()).map(StringFont::getPath).toArray(String[]::new);
            STRING_FONT[index.ordinal()] = loadImage(stringFonts[index.ordinal()]);
            System.out.println("Loaded string fonts " + index);
        }
        return STRING_FONT[index.ordinal()];
    }

    public static BufferedImage getBorder(BorderIndex index) {
        // Load borders
        if (BORDERS[index.ordinal()] == null) {
            String[] borderNames = new String[]{"/game/border/border_primary.png", "/game/border/top_left.png", "/game/border/top_right.png", "/game/border/bot_left.png", "/game/border/bot_right.png", "/game/border/border_top.png", "/game/border/border_bot.png", "/game/border/border_left.png", "/game/border/border_right.png"};
            BORDERS[index.ordinal()] = loadImage(borderNames[index.ordinal()]);
            System.out.println("Loaded borders " + index);
        }
        return BORDERS[index.ordinal()];
    }

    public static BufferedImage getWorldMap() {
        // Load world map
        if (WORLD_MAP == null) {
            WORLD_MAP = loadImage("/game/world_map.png");
            System.out.println("Loaded world map");
        }
        return WORLD_MAP;
    }

    public static BufferedImage getWorldMapPointer() {
        if (WORLD_MAP_POINTER == null) {
            // Load world map pointer
            WORLD_MAP_POINTER = loadImage("/game/u/wpt1.png");
            System.out.println("Loaded world map pointer");
        }
        return WORLD_MAP_POINTER;
    }

    public static BufferedImage getStar() {
        if (STAR == null) {
            // Load star
            STAR = loadImage("/game/u/star.png");
            System.out.println("Loaded star");
        }
        return STAR;
    }

    public static BufferedImage getSpinner(int index) {
        if (SPINNER[0] == null) {
            // Load spinner
            BufferedImage spinner = loadImage("/game/u/spinner.png");
            SPINNER[0] = spinner.getSubimage(0, 0, 16, 16);
            SPINNER[1] = spinner.getSubimage(0, 16, 16, 16);
            SPINNER[2] = spinner.getSubimage(0, 32, 16, 16);
            System.out.println("Loaded spinner");
        }
        return SPINNER[index];
    }

    public static BufferedImage getSmallButton(int index) {
        if (SMALL_BUTTON[index] == null) {
            // Load small button
            String[] smallButtonNames = new String[]{"/game/button/small/small1.png", "/game/button/small/small2.png"};
            SMALL_BUTTON[index] = loadImage(smallButtonNames[index]);
            System.out.println("Loaded small buttons " + index);
        }
        return SMALL_BUTTON[index];
    }

    public static BufferedImage getMapAsset(int index) {
        if (MAP_ASSETS[index] == null) {
            // Load map assets
            String[] mapAssetNames = new String[]{"/game/mapassets/1.png", "/game/mapassets/2.png", "/game/mapassets/3.png", "/game/mapassets/4.png"};
            MAP_ASSETS[index] = loadImage(mapAssetNames[index]);
            System.out.println("Loaded map assets");
        }
        return MAP_ASSETS[index];
    }

    public static BufferedImage getWaterSlide() {
        if (WATER_SLIDE == null) {
            // Load water slide
            WATER_SLIDE = loadImage("/game/img/water_slide.png");
            System.out.println("Loaded water slide");
        }
        return WATER_SLIDE;
    }

    public static BufferedImage getTopWaterFall() {
        if (TOP_WATER_FALL == null) {
            // Load top water fall
            TOP_WATER_FALL = loadImage("/game/img/top_water_fall.png");
            System.out.println("Loaded top water fall");
        }
        return TOP_WATER_FALL;
    }

    public static BufferedImage getWaterFall() {
        if (WATER_FALL == null) {
            // Load water fall
            WATER_FALL = loadImage("/game/img/water_fall.png");
            System.out.println("Loaded water fall");
        }
        return WATER_FALL;
    }
}

package com.minhkakart.ninjaschool.game.managers;

import com.minhkakart.ninjaschool.Main;
import com.minhkakart.ninjaschool.game.enums.BorderIndex;
import com.minhkakart.ninjaschool.game.enums.NumberFontColor;
import com.minhkakart.ninjaschool.game.enums.StringFont;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("unused")
public class ResourceManager {
    private static BufferedImage[] CORE_IMAGE;
    private static BufferedImage[] MAP_BACKGROUND;
    private static BufferedImage[] MAP_VIEW;
    private static BufferedImage[] MINI_MAP;
    private static BufferedImage[] NUMBER_FONT;
    private static BufferedImage[] STRING_FONT;
    private static BufferedImage[] BORDERS;
    private static BufferedImage[] SPINNER;
    private static BufferedImage[] SMALL_BUTTON;
    private static BufferedImage WORLD_MAP;
    private static BufferedImage WORLD_MAP_POINTER;
    private static BufferedImage STAR;
    private static BufferedImage[] MAP_ASSETS;
    private static BufferedImage WATER_SLIDE;
    private static BufferedImage TOP_WATER_FALL;
    private static BufferedImage WATER_FALL;

    static {
        try {
            loadResources();
        } catch (IOException e) {
            System.err.println("Error loading resources: " + e.getMessage());
        }
    }

    public static void loadResources() throws IOException {
        // Load core game resources
        String[] coreImages = new String[]{"/game/img/Big0.png", "/game/img/Big1.png", "/game/img/Big2.png", "/game/img/Big3.png", "/game/img/Big4.png"};
        CORE_IMAGE = loadImages(coreImages);
        System.out.println("Loaded core images");

        // Load map background
        InputStream inputStream;
        String[] bgNames = new String[]{"/game/bg/bg00.png", "/game/bg/bg01.png", "/game/bg/bg010.png", "/game/bg/bg011.png", "/game/bg/bg013.png", "/game/bg/bg014.png", "/game/bg/bg015.png", "/game/bg/bg016.png", "/game/bg/bg02.png", "/game/bg/bg03.png", "/game/bg/bg04.png", "/game/bg/bg05.png", "/game/bg/bg06.png", "/game/bg/bg07.png", "/game/bg/bg08.png", "/game/bg/bg09.png", "/game/bg/bg10.png", "/game/bg/bg11.png", "/game/bg/bg113.png", "/game/bg/bg114.png", "/game/bg/bg115.png", "/game/bg/bg116.png", "/game/bg/bg12.png", "/game/bg/bg13.png", "/game/bg/bg15.png", "/game/bg/bg16.png", "/game/bg/bg17.png", "/game/bg/bg18.png", "/game/bg/bg20.png", "/game/bg/bg21.png", "/game/bg/bg214.png", "/game/bg/bg216.png", "/game/bg/bg22.png", "/game/bg/bg23.png", "/game/bg/bg25.png", "/game/bg/bg26.png", "/game/bg/bg28.png", "/game/bg/bg30.png", "/game/bg/bg31.png", "/game/bg/bg314.png", "/game/bg/bg32.png", "/game/bg/bg33.png", "/game/bg/bg34.png", "/game/bg/bg35.png", "/game/bg/bg37.png", "/game/bg/bg38.png", "/game/bg/bg39.png", "/game/bg/cl0.png", "/game/bg/cl1.png", "/game/bg/cl2.png", "/game/bg/cl3.png", "/game/bg/moon.png", "/game/bg/sun.png"};
//        MAP_BACKGROUND = loadImages(bgNames);
        MAP_BACKGROUND = new BufferedImage[bgNames.length];
        for (int i = 0; i < bgNames.length; i++) {
            inputStream = getInputStream(bgNames[i]);
            assert inputStream != null;
            MAP_BACKGROUND[i] = ImageIO.read(inputStream);
            System.out.println("Loaded map background " + bgNames[i].replace("/game/bg/", "") + ", index: " + i);
        }
        System.out.println("Loaded map backgrounds");

        // Load map view
        String[] mapViews = new String[]{"/game/mapassets/1.png", "/game/mapassets/2.png", "/game/mapassets/3.png", "/game/mapassets/4.png"};
        MAP_VIEW = loadImages(mapViews);
        System.out.println("Loaded map views");

        // Load mini map
        String[] miniMaps = new String[]{"/game/t/mini_1.png", "/game/t/mini_2.png", "/game/t/mini_3.png", "/game/t/mini_4.png"};
        MINI_MAP = loadImages(miniMaps);
        System.out.println("Loaded mini maps");

        // Load number font
        String[] numberFonts = new String[]{"/game/font/number_green.png", "/game/font/number_orange.png", "/game/font/number_red.png", "/game/font/number_white.png", "/game/font/number_yellow.png"};
        NUMBER_FONT = loadImages(numberFonts);
        System.out.println("Loaded number fonts");

        // Load string font
        String[] stringFonts = Arrays.stream(StringFont.values()).map(StringFont::getPath).toArray(String[]::new);
        STRING_FONT = loadImages(stringFonts);
        System.out.println("Loaded string fonts");

        // Load borders
        String[] borderNames = new String[]{"/game/border/border_primary.png", "/game/border/top_left.png", "/game/border/top_right.png", "/game/border/bot_left.png", "/game/border/bot_right.png", "/game/border/border_top.png", "/game/border/border_bot.png", "/game/border/border_left.png", "/game/border/border_right.png"};
        BORDERS = loadImages(borderNames);
        System.out.println("Loaded borders");
        
        // Load world map
        WORLD_MAP = loadImage("/game/world_map.png");
        System.out.println("Loaded world map");
        
        // Load world map pointer
        WORLD_MAP_POINTER = loadImage("/game/u/wpt1.png");
        System.out.println("Loaded world map pointer");
        
        // Load star
        STAR = loadImage("/game/u/star.png");
        System.out.println("Loaded star");
        
        // Load spinner
        BufferedImage spinner = loadImage("/game/u/spinner.png");
        SPINNER = new BufferedImage[3];
        SPINNER[0] = spinner.getSubimage(0, 0, 16, 16);
        SPINNER[1] = spinner.getSubimage(0, 16, 16, 16);
        SPINNER[2] = spinner.getSubimage(0, 32, 16, 16);
        System.out.println("Loaded spinner");
        
        // Load small button
        String[] smallButtonNames = new String[]{"/game/button/small/small1.png", "/game/button/small/small2.png"};
        SMALL_BUTTON = loadImages(smallButtonNames);
        System.out.println("Loaded small buttons");
        
        // Load map assets
        String[] mapAssetNames = new String[]{"/game/mapassets/1.png", "/game/mapassets/2.png", "/game/mapassets/3.png", "/game/mapassets/4.png"};
        MAP_ASSETS = loadImages(mapAssetNames);
        System.out.println("Loaded map assets");
        
        // Load water slide
        WATER_SLIDE = loadImage("/game/img/water_slide.png");
        System.out.println("Loaded water slide");
        
        // Load top water fall
        TOP_WATER_FALL = loadImage("/game/img/top_water_fall.png");
        System.out.println("Loaded top water fall");
        
        // Load water fall
        WATER_FALL = loadImage("/game/img/water_fall.png");
        System.out.println("Loaded water fall");

    }

    public static InputStream getInputStream(String path) {
        return Main.class.getResourceAsStream(path);
    }

    public static BufferedImage[] loadImages(String[] paths) throws IOException {
        InputStream inputStream;
        List<BufferedImage> images = new ArrayList<>(paths.length);
        for (String path : paths) {
            images.add(loadImage(path));
        }
        return images.toArray(new BufferedImage[0]);
    }

    public static BufferedImage loadImage(String path) throws IOException {
        InputStream inputStream;
        inputStream = getInputStream(path);
        assert inputStream != null;
        return ImageIO.read(inputStream);
    }

    public static BufferedImage getCoreImage(int index) {
        return CORE_IMAGE[index];
    }

    public static BufferedImage getMapBackground(int index) {
        return MAP_BACKGROUND[index];
    }

    public static BufferedImage getMapView(int index) {
        return MAP_VIEW[index];
    }

    public static BufferedImage getMiniMap(int index) {
        return MINI_MAP[index];
    }

    public static BufferedImage getNumberFont(NumberFontColor index) {
        return NUMBER_FONT[index.ordinal()];
    }

    public static BufferedImage getStringFont(StringFont index) {
        return STRING_FONT[index.ordinal()];
    }

    public static BufferedImage getBorder(BorderIndex index) {
        return BORDERS[index.ordinal()];
    }
    
    public static BufferedImage getWorldMap() {
        return WORLD_MAP;
    }
    
    public static BufferedImage getWorldMapPointer() {
        return WORLD_MAP_POINTER;
    }
    
    public static BufferedImage getStar() {
        return STAR;
    }
    
    public static BufferedImage getSpinner(int index) {
        return SPINNER[index];
    }
    
    public static BufferedImage getSmallButton(int index) {
        return SMALL_BUTTON[index];
    }
    
    public static BufferedImage getMapAsset(int index) {
        return MAP_ASSETS[index];
    }
    
    public static BufferedImage getWaterSlide() {
        return WATER_SLIDE;
    }
    
    public static BufferedImage getTopWaterFall() {
        return TOP_WATER_FALL;
    }
    
    public static BufferedImage getWaterFall() {
        return WATER_FALL;
    }
}

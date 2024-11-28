package com.minhkakart.ninjaschool.game.layers;

import com.minhkakart.ninjaschool.game.components.SmallButton;
import com.minhkakart.ninjaschool.game.configurations.GlobalConfig;
import com.minhkakart.ninjaschool.game.enums.LayerDepth;
import com.minhkakart.ninjaschool.game.enums.StringFont;
import com.minhkakart.ninjaschool.game.enums.WorldMap;
import com.minhkakart.ninjaschool.game.interfaces.Drawable;
import com.minhkakart.ninjaschool.game.managers.LayerManager;
import com.minhkakart.ninjaschool.game.managers.ResourceManager;
import com.minhkakart.ninjaschool.game.models.Spinner;
import com.minhkakart.ninjaschool.game.supports.Drawer;
import com.minhkakart.ninjaschool.game.supports.ScaleSupporter;
import com.minhkakart.ninjaschool.game.supports.TextSupporter;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;

public class WorldMapLayer extends GameLayer {
    //    private static final double WORLD_MAP_SCALE = 0.6;
    private static final AffineTransform WORLD_MAP_TRANSFORM = new AffineTransform();
    private static final int MIN_TRANSLATE = -100;
    private static final int MAX_TRANSLATE = 20;

    // Player's position imaginary position on the map
    private final WorldMap playerPosition = WorldMap.HIROSAKI_SCHOOL;
    private final SmallButton backButton = new SmallButton("Đóng", new Point(320, 215));
    private final Spinner spinner;
    private final WorldMapPointer worldMapPointer = new WorldMapPointer(playerPosition.getCenterBound());

    private Point prevPoint;

    static {
        WORLD_MAP_TRANSFORM.translate(((double) GlobalConfig.ORIGINAL_WIDTH - ResourceManager.getWorldMap().getWidth()) / 2, MAX_TRANSLATE);
    }

    public WorldMapLayer() {
        super(LayerDepth.WORLD_MAP);
        spinner = new Spinner(new Point(playerPosition.getCenterBound().x + (int) WORLD_MAP_TRANSFORM.getTranslateX(), playerPosition.getCenterBound().y + (int) WORLD_MAP_TRANSFORM.getTranslateY()));
        worldMapPointer.translate((int) WORLD_MAP_TRANSFORM.getTranslateX(), (int) WORLD_MAP_TRANSFORM.getTranslateY());
        
        backButton.setActionListener((e) -> {
            spinner.stop();
            LayerManager.removeLayer(this);
        });

        addInputListener(backButton);
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        super.draw(graphics2D);

        // Draw map
        graphics2D.fill(GlobalConfig.GAME_SHAPE);
        graphics2D.drawImage(ResourceManager.getWorldMap(), WORLD_MAP_TRANSFORM, null);

        // Draw spinner
        spinner.draw(graphics2D);
        // Draw map info
        int wordWidth = TextSupporter.getStringBound(playerPosition.getMapName(), StringFont.TAHOMA_7_YELLOW)[0];
        Drawer.drawShadowString(playerPosition.getMapName(), spinner.getPosition().x - wordWidth / 2, spinner.getPosition().y - 20, graphics2D, StringFont.TAHOMA_7_YELLOW);

        // Draw pointer
        worldMapPointer.draw(graphics2D);

        // Draw back button
        backButton.draw(graphics2D);
    }

    private static Rectangle getWorldMapBound() {
        return new Rectangle((int) WORLD_MAP_TRANSFORM.getTranslateX(), (int) WORLD_MAP_TRANSFORM.getTranslateY(), ResourceManager.getWorldMap().getWidth(), ResourceManager.getWorldMap().getHeight());
    }
    
    private static Point getUnTranslatedPoint(Point point) {
        return new Point((int) (point.getX() - WORLD_MAP_TRANSFORM.getTranslateX()), (int) (point.getY() - WORLD_MAP_TRANSFORM.getTranslateY()));
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
        if (getWorldMapBound().contains(ScaleSupporter.getUnscaledPoint(e.getPoint()))) {
            worldMapPointer.setLocation(ScaleSupporter.getUnscaledPoint(e.getPoint()));
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        super.mousePressed(e);
        prevPoint = ScaleSupporter.getUnscaledPoint(e.getPoint());
        backButton.mousePressed(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        super.mouseReleased(e);
        backButton.mouseReleased(e);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        super.mouseDragged(e);

        if (prevPoint != null) {
            Point newPoint = ScaleSupporter.getUnscaledPoint(e.getPoint());
            Point translate = new Point((int) (newPoint.getX() - prevPoint.getX()), (int) (newPoint.getY() - prevPoint.getY()));
            prevPoint = newPoint;
            if (WORLD_MAP_TRANSFORM.getTranslateY() + translate.getY() >= MIN_TRANSLATE && WORLD_MAP_TRANSFORM.getTranslateY() + translate.getY() <= MAX_TRANSLATE) {
                WORLD_MAP_TRANSFORM.translate(0, translate.getY());
                worldMapPointer.translate(0, translate.y);
                spinner.translate(0, translate.y);
            }
        }
    }

    private static class WorldMapPointer implements Drawable {
        private Point location;
        private WorldMap worldMapLocation;

        public WorldMapPointer(Point location) {
            this.location = location;
        }

        public void setLocation(Point position) {
            this.location = position;
            this.worldMapLocation = getWorldMap();
        }

        public void translate(int x, int y) {
            location.translate(x, y);
            this.worldMapLocation = getWorldMap();
        }

        public WorldMap getWorldMap() {
            for (WorldMap worldMap : WorldMap.values()) {
                if (worldMap.getBound().contains(getUnTranslatedPoint(location))) {
                    return worldMap;
                }
            }
            return null;
        }


        @Override
        public void draw(Graphics2D graphics2D) {
            graphics2D.drawImage(ResourceManager.getWorldMapPointer(), location.x - 2, location.y, null);
            if (worldMapLocation != null) {
                int wordWidth = TextSupporter.getStringBound(worldMapLocation.getMapName(), StringFont.TAHOMA_7_YELLOW)[0];
                Drawer.drawShadowString(worldMapLocation.getMapName(), location.x - wordWidth / 2, location.y - 20, graphics2D, StringFont.TAHOMA_7_YELLOW);
            }
        }
    }
}

package com.minhkakart.ninjaschool.game.layers;

import com.minhkakart.ninjaschool.game.enums.LayerDepth;
import com.minhkakart.ninjaschool.game.enums.MapInfo;
import com.minhkakart.ninjaschool.game.models.MapObject;
import com.minhkakart.ninjaschool.game.supports.ScaleSupporter;

import java.awt.*;
import java.awt.event.MouseEvent;

public class MapViewLayer extends GameLayer {
    private MapObject mapObject;
    private Point prevPoint;
    
    public MapViewLayer() {
        super(LayerDepth.MAP_VIEW);
        mapObject = MapObject.loadMap(MapInfo.TONE_VILLAGE);
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        super.draw(graphics2D);
        mapObject.draw(graphics2D);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        super.mousePressed(e);
        prevPoint = ScaleSupporter.getUnscaledPoint(e.getPoint());
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        super.mouseDragged(e);
        Point currentPoint = ScaleSupporter.getUnscaledPoint(e.getPoint());
        int dx = currentPoint.x - prevPoint.x;
        int dy = currentPoint.y - prevPoint.y;
        mapObject.move(dx, dy);
        prevPoint = currentPoint;
    }
}

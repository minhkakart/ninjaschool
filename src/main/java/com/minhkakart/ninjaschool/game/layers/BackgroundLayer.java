package com.minhkakart.ninjaschool.game.layers;

import com.minhkakart.ninjaschool.game.enums.LayerDepth;
import com.minhkakart.ninjaschool.game.managers.BackgroundManager;

import java.awt.*;

public class BackgroundLayer extends GameLayer {
    public BackgroundLayer() {
        super(LayerDepth.BACKGROUND);
    }
    
    @Override
    public void draw(Graphics2D graphics2D) {
        super.draw(graphics2D);
        BackgroundManager.getBackground().draw(graphics2D);
    }

}

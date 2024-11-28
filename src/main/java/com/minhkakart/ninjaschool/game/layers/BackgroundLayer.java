package com.minhkakart.ninjaschool.game.layers;

import com.minhkakart.ninjaschool.game.enums.BackgroundPlace;
import com.minhkakart.ninjaschool.game.enums.LayerDepth;
import com.minhkakart.ninjaschool.game.models.Background;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("unused")
public class BackgroundLayer extends GameLayer {
    private final Background background;

    private final Timer randomBackgroundTimer;

    public BackgroundLayer() {
        super(LayerDepth.BACKGROUND);

        this.background = new Background(Background.getRandomPlace());

        randomBackgroundTimer = new Timer(5000, e -> background.changeBackground(Background.getRandomPlace()));
        setRandomBackground(true);
    }

    public void setBackground(BackgroundPlace place) {
        randomBackgroundTimer.stop();
        background.changeBackground(place);
    }
    
    public void setRandomBackground(boolean random) {
        try {
            if (random) {
                randomBackgroundTimer.restart();
            } else {
                randomBackgroundTimer.stop();
            }
        } catch (Exception e) {
            System.err.println("Error setting random background: " + e.getMessage());
        }
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        super.draw(graphics2D);
        background.draw(graphics2D);
    }

}

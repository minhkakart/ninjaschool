package com.minhkakart.ninjaschool.game.managers;

import com.minhkakart.ninjaschool.game.enums.BackgroundPlace;
import com.minhkakart.ninjaschool.game.models.Background;

import javax.swing.*;

public class BackgroundManager {
    private static final Background background = new Background(Background.getRandomPlace());
    private static final Background backgroundRandom = new Background(Background.getRandomPlace());

    private static final Timer randomBackgroundTimer = new Timer(5000, e -> backgroundRandom.changeBackground(Background.getRandomPlace()));

    public static Background getBackground() {
        if (MapManager.getCurrentMapId() == null) {
            if (!randomBackgroundTimer.isRunning()) {
                randomBackgroundTimer.start();
            }
            return backgroundRandom;
        }
        if (randomBackgroundTimer.isRunning()) {
            randomBackgroundTimer.stop();
        }
        return background;
    }
    
    public static void setBackgroundPlace(BackgroundPlace place) {
        background.changeBackground(place);
    }
}

package com.minhkakart.ninjaschool.game.models;

import com.minhkakart.ninjaschool.game.configurations.GlobalConfig;
import com.minhkakart.ninjaschool.game.enums.BackgroundPlace;
import com.minhkakart.ninjaschool.game.interfaces.Drawable;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Random;

public class Background implements Drawable {
    private BackgroundPlace place;
    private final Timer[] timers = new Timer[4];
    private final int[] offsets = new int[4];
    private final int[] offsetTime = {1357, 579, 257, 127};
    
    private static int currentPlaceIndex = -1;

    public Background(BackgroundPlace place) {
        this.place = place;
        currentPlaceIndex = Arrays.asList(BackgroundPlace.values()).indexOf(place);
        initTimers();
        if (place.isSliding()) {
            startSliding();
        }
    }
    
    private void initTimers() {
        for (int i = 0; i < timers.length; i++) {
            int finalI = i;
            timers[i] = new Timer(offsetTime[i], e -> {
                offsets[finalI]++;
                if (offsets[finalI] >= place.getImageParts()[finalI].getImage().getWidth(null)) {
                    offsets[finalI] = 0;
                }
            });
        }
    }

    private void stopTimers() {
        try {
            for (Timer timer : timers) {
                timer.stop();
            }
            Arrays.fill(offsets, 0);
        } catch (Exception e) {
            System.err.println("Error stopping timers: " + e.getMessage());
        }
    }

    private void startSliding() {
        stopTimers();
        for (Timer timer : timers) {
            timer.start();
        }
    }

    public synchronized void changeBackground(BackgroundPlace place) {
        this.place = place;
        if (place.isSliding()) {
            startSliding();
        } else {
            stopTimers();
        }
    }
    
    public static BackgroundPlace getRandomPlace() {
        BackgroundPlace[] places = BackgroundPlace.values();
        Random random = new Random();
        int index = random.nextInt(places.length);
        while (index == currentPlaceIndex){
            index = random.nextInt(places.length);
        }
        currentPlaceIndex = index;
        return places[index];
    }

    @Override
    public synchronized void draw(Graphics2D graphics2D) {
        // Draw background here
        graphics2D.setColor(place.getBackgroundColor());
        graphics2D.fillRect(0, 0, GlobalConfig.GAME_WIDTH, GlobalConfig.GAME_HEIGHT);

        for (int partIndex = 0; partIndex < place.getImageParts().length; partIndex++) {
            BackgroundPlace.ImagePart imagePart = place.getImageParts()[partIndex];
            Image img = imagePart.getImage();
            int numCount = GlobalConfig.ORIGINAL_WIDTH / img.getWidth(null) + 10;
            for (int i = 0; i < numCount; i++) {
                graphics2D.drawImage(img, i * img.getWidth(null) + imagePart.getPosition().x - offsets[partIndex], imagePart.getPosition().y, null);
            }
        }
    }

}

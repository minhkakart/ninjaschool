package com.minhkakart.ninjaschool.game.models;

import com.minhkakart.ninjaschool.game.interfaces.Drawable;
import com.minhkakart.ninjaschool.game.managers.ResourceManager;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Spinner implements Drawable {
    private final Point position;
    private final Thread run;

    private int index = 0;
    private boolean isAlive = true;

    public Spinner(Point position) {
        this.position = position;
        run = new Thread(this::spin);
        run.start();
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        BufferedImage spinner = ResourceManager.getSpinner(index);
        graphics2D.drawImage(spinner, position.x - spinner.getWidth() / 2, position.y - spinner.getHeight() / 2, null);
    }

    private void spin() {
        while (isAlive) {
            try {
                index = (index + 1) % 3;
                Thread.sleep(50);
            } catch (InterruptedException e) {
                System.err.println("Spinner error: " + e.getMessage());
            }
        }
    }

    public void stop() {
        isAlive = false;
    }
    
    public void translate(int x, int y) {
        this.position.translate(x, y);
    }

    public Point getPosition() {
        return position;
    }
}
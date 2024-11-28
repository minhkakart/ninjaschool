package com.minhkakart.ninjaschool.game.layers;

import com.minhkakart.ninjaschool.game.enums.LayerDepth;
import com.minhkakart.ninjaschool.game.interfaces.Drawable;
import com.minhkakart.ninjaschool.game.interfaces.InputListener;
import com.minhkakart.ninjaschool.game.supports.ScaleSupporter;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings("unused")
public class GameLayer implements Comparable<GameLayer>, Drawable, InputListener {
    protected final List<InputListener> inputListeners = new ArrayList<>();

    private LayerDepth depth;
    private String name;

    public GameLayer() {
        depth = LayerDepth.DEFAULT;
        name = "Layer " + depth;
    }

    public GameLayer(LayerDepth depth) {
        this();
        this.name = depth.getName();
        this.depth = depth;
    }

    public static GameLayer getInstance() {
        return new GameLayer();
    }

    public String getName() {
        return name;
    }

    public LayerDepth getDepth() {
        return depth;
    }
    
    protected void addInputListener(InputListener ...inputListener) {
        Collections.addAll(inputListeners, inputListener);
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        graphics2D.setClip(null);
        graphics2D.rotate(0);
        graphics2D.scale(1, 1);
        graphics2D.translate(0, 0);
        graphics2D.setColor(Color.BLACK);
    }

    @Override
    public int compareTo(GameLayer o) {
        return depth.getDepth() - o.depth.getDepth();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        inputListeners.forEach(listener -> listener.keyTyped(e));
    }

    @Override
    public void keyPressed(KeyEvent e) {
        inputListeners.forEach(listener -> listener.keyPressed(e));
    }

    @Override
    public void keyReleased(KeyEvent e) {
        inputListeners.forEach(listener -> listener.keyReleased(e));
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        inputListeners.forEach(listener -> listener.mouseClicked(e));
    }

    @Override
    public void mousePressed(MouseEvent e) {
        inputListeners.forEach(listener -> listener.mousePressed(e));
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        inputListeners.forEach(listener -> listener.mouseReleased(e));
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        inputListeners.forEach(listener -> listener.mouseEntered(e));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        inputListeners.forEach(listener -> listener.mouseExited(e));
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        inputListeners.forEach(listener -> listener.mouseDragged(e));
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        inputListeners.forEach(listener -> listener.mouseMoved(e));
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        inputListeners.forEach(listener -> listener.mouseWheelMoved(e));
    }
}

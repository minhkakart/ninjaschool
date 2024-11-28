package com.minhkakart.ninjaschool.game.components;

import com.minhkakart.ninjaschool.game.interfaces.Drawable;
import com.minhkakart.ninjaschool.game.interfaces.InputListener;
import com.minhkakart.ninjaschool.game.supports.ScaleSupporter;

import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("unused")
public abstract class GameButton implements InputListener, Drawable {
    protected final String name;
    protected final Point position;

    protected int btnWidth = 0;
    protected int btnHeight = 0;

    protected ActionListener actionListener;

    protected boolean isFocused = false;

    public GameButton(String name) {
        this.name = name;
        this.position = new Point(0, 0);
    }

    public GameButton(String name, Point position) {
        this.name = name;
        this.position = position;
    }

    public int getBtnWidth() {
        return btnWidth;
    }

    public int getBtnHeight() {
        return btnHeight;
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point point) {
        position.setLocation(point);
    }
    
    public void setActionListener(ActionListener actionListener) {
        this.actionListener = actionListener;
    }

    public synchronized void setFocused(boolean focus) {
        this.isFocused = focus;
    }

    protected synchronized boolean isFocused() {
        return isFocused;
    }
    
    public void performAction() {
        if (actionListener != null) {
            actionListener.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, name));
        }
    }

    public abstract Rectangle getBound();

    @Override
    public abstract void draw(Graphics2D graphics2D);

    @Override
    public void mouseClicked(MouseEvent e) {
        if (getBound().contains(ScaleSupporter.getUnscaledPoint(e.getPoint()))) {
            performAction();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (getBound().contains(ScaleSupporter.getUnscaledPoint(e.getPoint()))) {
            setFocused(true);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        setFocused(false);
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {

    }
}

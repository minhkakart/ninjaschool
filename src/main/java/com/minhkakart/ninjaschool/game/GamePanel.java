package com.minhkakart.ninjaschool.game;

import com.minhkakart.ninjaschool.game.configurations.GlobalConfig;
import com.minhkakart.ninjaschool.game.interfaces.InputListener;
import com.minhkakart.ninjaschool.game.layers.BackgroundLayer;
import com.minhkakart.ninjaschool.game.layers.GameLayer;
import com.minhkakart.ninjaschool.game.layers.MapViewLayer;
import com.minhkakart.ninjaschool.game.layers.StartLayer;
import com.minhkakart.ninjaschool.game.managers.LayerManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.geom.AffineTransform;

public class GamePanel extends JPanel implements InputListener {
    /* Count FPS
    private static int FPS_COUNT;
    private static long FPS_TIME;
    */

    public GamePanel() {
        setLayout(null);
        setFocusable(true);
        setPreferredSize(new Dimension(GlobalConfig.GAME_WIDTH, GlobalConfig.GAME_HEIGHT));
        LayerManager.addLayer(new BackgroundLayer(), new StartLayer());
//        LayerManager.addLayer(new BackgroundLayer(), new MapViewLayer());

        addKeyListener(this);
        addMouseListener(this);
        addMouseWheelListener(this);
        addMouseMotionListener(this);

        start();
    }

    public void start() {
        new Timer(1000 / GlobalConfig.GAME_FPS, e -> repaint()).start();
        /* Count FPS
        new Thread(() -> {
            System.out.println("GamePanel started");
            FPS_COUNT = 0;
            FPS_TIME = System.currentTimeMillis();
            while (true) {
                long currentTime = System.currentTimeMillis();
                if (currentTime - FPS_TIME >= 1000) {
                    System.out.println("FPS: " + FPS_COUNT);
                    FPS_COUNT = 0;
                    FPS_TIME = currentTime;
                }
                repaint();
                FPS_COUNT++;
            }
        }).start();
        */

    }

    public void Exit() {
        System.out.println("Exited!");
        System.exit(0);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        AffineTransform transform = g2d.getTransform();
        transform.scale(GlobalConfig.GAME_SCALE, GlobalConfig.GAME_SCALE);
        g2d.setTransform(transform);

        // Draw game here
        for (GameLayer layer : LayerManager.getLayers()) {
            layer.draw(g2d);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        LayerManager.getActiveListeners().parallelStream().forEach(listener -> listener.mouseClicked(e));
    }

    @Override
    public void mousePressed(MouseEvent e) {
        LayerManager.getActiveListeners().parallelStream().forEach(listener -> listener.mousePressed(e));
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        LayerManager.getActiveListeners().parallelStream().forEach(listener -> listener.mouseReleased(e));
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        LayerManager.getActiveListeners().parallelStream().forEach(listener -> listener.mouseEntered(e));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        LayerManager.getActiveListeners().parallelStream().forEach(listener -> listener.mouseExited(e));
    }

    @Override
    public void keyTyped(KeyEvent e) {
        LayerManager.getActiveListeners().parallelStream().forEach(listener -> listener.keyTyped(e));
    }

    @Override
    public void keyPressed(KeyEvent e) {
        LayerManager.getActiveListeners().parallelStream().forEach(listener -> listener.keyPressed(e));
    }

    @Override
    public void keyReleased(KeyEvent e) {
        LayerManager.getActiveListeners().parallelStream().forEach(listener -> listener.keyReleased(e));
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        LayerManager.getActiveListeners().parallelStream().forEach(listener -> listener.mouseDragged(e));
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        LayerManager.getActiveListeners().parallelStream().forEach(listener -> listener.mouseMoved(e));
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        LayerManager.getActiveListeners().parallelStream().forEach(listener -> listener.mouseWheelMoved(e));
    }
}

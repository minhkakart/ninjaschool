package com.minhkakart.ninjaschool.game.layers;

import com.minhkakart.ninjaschool.game.GameFrame;
import com.minhkakart.ninjaschool.game.components.TextView;
import com.minhkakart.ninjaschool.game.configurations.GlobalConfig;
import com.minhkakart.ninjaschool.game.enums.ButtonSize;
import com.minhkakart.ninjaschool.game.enums.LayerDepth;
import com.minhkakart.ninjaschool.game.managers.LayerManager;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.util.ArrayList;
import java.util.List;

public class StartLayer extends GameLayer {
    private final List<TextView> textViews = new ArrayList<>();
    private final int centerHorizontal = (GlobalConfig.ORIGINAL_WIDTH - ButtonSize.START_BUTTON.getWidth()) / 2;

    private int selectedButtonIndex = -1;
    
    public StartLayer() {
        super(LayerDepth.START);
        TextView newGameButton = new TextView("Chơi mới");
        newGameButton.setActionListener(e -> {
            LayerManager.removeLayer(this);
            LayerManager.addLayer(new MapViewLayer());
        });

        TextView continueButton = new TextView("Map");
        continueButton.setActionListener(e -> LayerManager.addLayer(new WorldMapLayer()));

        TextView exitButton = new TextView("Thoát");
        exitButton.setActionListener(e -> {
            System.out.println("Exiting...");
            GameFrame.mainPanel.Exit();
        });
        addButtons(newGameButton, continueButton, exitButton);
    }
    
    private void addButton(TextView button) {
        textViews.add(button);
        
        int buttonCount = textViews.size();
        int buttonHeight = ButtonSize.START_BUTTON.getHeight();
        
        int totalButtonHeight = buttonCount * buttonHeight + (buttonCount - 1) * 10;
        
        int startY = (GlobalConfig.ORIGINAL_HEIGHT - totalButtonHeight) / 2;
        
        for (int i = 0; i < buttonCount; i++) {
            int gap = 10;
            TextView textView = textViews.get(i);
            textView.setPosition(new Point(centerHorizontal, startY + i * (buttonHeight + gap)));
        }
    }
    
    private void addButtons(TextView... buttons) {
        for (TextView button : buttons) {
            addButton(button);
        }
    }

    private void moveFocusedButton(int move) {
        if (move > 0) {
            selectedButtonIndex++;
        } else {
            selectedButtonIndex--;
        }

        if (selectedButtonIndex < 0) {
            selectedButtonIndex = textViews.size() - 1;
        } else if (selectedButtonIndex >= textViews.size()) {
            selectedButtonIndex = 0;
        }

        for (int i = 0; i < textViews.size(); i++) {
            TextView textView = textViews.get(i);
            textView.setFocused(i == selectedButtonIndex);
        }
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        super.draw(graphics2D);
        for (TextView textView : textViews) {
            textView.draw(graphics2D);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
        for (TextView textView : textViews) {
            textView.mouseClicked(e);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        super.mousePressed(e);
        for (TextView textView : textViews) {
            textView.mousePressed(e);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        super.mouseReleased(e);
        for (TextView textView : textViews) {
            textView.mouseReleased(e);
        }
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        super.mouseWheelMoved(e);
        int move = e.getWheelRotation();
        moveFocusedButton(move);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        super.keyTyped(e);
        if (e.getKeyChar() == KeyEvent.VK_ENTER) {
            if (selectedButtonIndex >= 0 && selectedButtonIndex < textViews.size()) {
                TextView textView = textViews.get(selectedButtonIndex);
                textView.performAction();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        super.keyReleased(e);
        System.out.println("Key released: " + e.getKeyCode());
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            moveFocusedButton(-1);
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            moveFocusedButton(1);
        }
    }
}

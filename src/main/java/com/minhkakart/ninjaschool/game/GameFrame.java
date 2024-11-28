package com.minhkakart.ninjaschool.game;

import javax.swing.*;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import static com.minhkakart.ninjaschool.game.configurations.GlobalConfig.GAME_TITLE;

public class GameFrame extends JFrame {
    public static final GamePanel mainPanel = new GamePanel();
    
    public GameFrame() {
        add(mainPanel);
        pack();
        setTitle(GAME_TITLE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                mainPanel.Exit();
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GameFrame());
    }
}

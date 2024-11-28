package com.minhkakart.ninjaschool;

import com.minhkakart.ninjaschool.game.GameFrame;

import javax.swing.*;

@SuppressWarnings("CallToPrintStackTrace")
public class Main {
    public static void main(String[] args) {
        try {
            SwingUtilities.invokeLater(GameFrame::new);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
package com.translator.Translator.key_Listener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyKeyListener implements KeyListener {
    @Override
    public void keyPressed(KeyEvent e) {
        //check whether CTRL and C are pressed together. Then save to DB
        if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_C) {
            String selectedText = getSelectedText();
            saveToDatabase(selectedText);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    private String getSelectedText() {
        return null;
    }

    private void saveToDatabase(String text) {
    }
}


package com.translator.Translator.key_Listener;

import com.translator.Translator.service.TranslateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

public class MyKeyListener implements KeyListener {

    private TranslateService translateService;
    Logger logger = LoggerFactory.getLogger(MyKeyListener.class);



    public MyKeyListener(TranslateService translateService) {
        this.translateService = translateService;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //check whether CTRL and C are pressed together. Then save to DB
        if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_C) {
            logger.info("Keys are pressed");
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
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        if (clipboard.isDataFlavorAvailable(DataFlavor.stringFlavor)) {
            try {
                logger.info("Getting word");
                // Получаем данные из буфера обмена в виде строки
                return (String) clipboard.getData(DataFlavor.stringFlavor);
            } catch (UnsupportedFlavorException | IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    private void saveToDatabase(String word) {
        translateService.saveWord(word);
    }
}


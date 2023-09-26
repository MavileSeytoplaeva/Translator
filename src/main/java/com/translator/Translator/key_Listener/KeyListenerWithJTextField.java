package com.translator.Translator.key_Listener;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import javax.swing.*;

public class KeyListenerWithJTextField implements KeyListener {

    @Override
    public void keyPressed(KeyEvent e) {
        // Обработка события нажатия клавиши
        if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_C) {
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            if (clipboard.isDataFlavorAvailable(DataFlavor.stringFlavor)) {
                try {
                    // Получаем данные из буфера обмена в виде строки
                    String data = (String) clipboard.getData(DataFlavor.stringFlavor);
                    System.out.println(data);
                } catch (UnsupportedFlavorException | IOException r) {
                    r.printStackTrace();
                }
            }
            System.out.println("Key Pressed: " + e.getKeyChar());
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Обработка события набора символа
        System.out.println("Key Typed: " + e.getKeyChar());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Обработка события отпускания клавиши
//        System.out.println("Key Released: " + e.getKeyChar());
    }

    public static void main(String[] args) {
        // Создание компонента JTextField
        JTextField textField = new JTextField();

        // Регистрация KeyListener для JTextField
        textField.addKeyListener(new KeyListenerWithJTextField());

        // Создание и настройка JFrame
        JFrame frame = new JFrame();
        frame.add(textField);
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}

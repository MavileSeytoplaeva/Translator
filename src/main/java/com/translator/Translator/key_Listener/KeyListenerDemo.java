package com.translator.Translator.key_Listener;


import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class MyKeyListenerDemo implements KeyListener {

    @Override
    public void keyPressed(KeyEvent e) {
        // Проверяем, нажаты ли одновременно CTRL и C
        if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_C) {
            System.out.println("CTRL + C pressed");
            // Дополнительные действия, если нужно
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    public static void main(String[] args) {
        // Создаем экземпляр MyKeyListener
        MyKeyListenerDemo keyListener = new MyKeyListenerDemo();

        // Регистрируем keyListener для компонента (например, окна приложения)
        // Ниже приведен пример для JFrame
//        JFrame frame = new JFrame();
//        frame.addKeyListener(keyListener);

        JTextField textField = new JTextField();

        // Регистрация KeyListener для JTextField
        textField.addKeyListener(new MyKeyListenerDemo());
//
//        // Отображаем окно приложения
        JFrame frame = new JFrame();
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}


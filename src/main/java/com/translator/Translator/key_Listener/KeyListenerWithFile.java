package com.translator.Translator.key_Listener;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;

public class KeyListenerWithFile implements KeyListener {

    @Override
    public void keyPressed(KeyEvent e) {
        // Обработка события нажатия клавиши
//        System.out.println("Key Pressed: " + e.getKeyChar());
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
        System.out.println("Key Released: " + e.getKeyChar());
    }

    public static void main(String[] args) {
        File file = new File("C:\\Users\\Мавиле\\Desktop\\file.txt"); // Замените "path/to/your/file.txt" на путь к вашему файлу

        KeyListenerWithFile keyListener = new KeyListenerWithFile();


        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(file));
            while (true) {
                String line = reader.readLine();
                if (line == null) {
                    // Если достигнут конец файла, перейти в начало файла и продолжить чтение
                    reader.close();
                    reader = new BufferedReader(new FileReader(file));
                    continue;
                }


                KeyEvent keyPressedEvent = new KeyEvent(new JPanel(), KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_UNDEFINED);
                keyListener.keyPressed(keyPressedEvent);


                // Обработка каждой строки файла
//                System.out.println(line);

                // Добавьте вашу логику здесь

                Thread.sleep(1000); // Приостановка выполнения на 1 секунду (необязательно)
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

//        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
//            KeyListenerWithFile keyListener = new KeyListenerWithFile();
//
//            int character;
//            while ((character = reader.read()) != -1) {
//                char c = (char) character;
//
//                // Обработка символа
//                System.out.println("Character: " + c);
//
//                // Вызов методов KeyListener
//                KeyEvent keyPressedEvent = new KeyEvent(new JPanel(), KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_UNDEFINED, c);
//                keyListener.keyPressed(keyPressedEvent);
//
//                KeyEvent keyTypedEvent = new KeyEvent(new JPanel(), KeyEvent.KEY_TYPED, System.currentTimeMillis(), 0, KeyEvent.VK_UNDEFINED, c);
//                keyListener.keyTyped(keyTypedEvent);
//
//                KeyEvent keyReleasedEvent = new KeyEvent(new JPanel(), KeyEvent.KEY_RELEASED, System.currentTimeMillis(), 0, KeyEvent.VK_UNDEFINED, c);
//                keyListener.keyReleased(keyReleasedEvent);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
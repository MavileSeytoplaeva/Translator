package com.translator.Translator.key_Listener;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class NewFileProcessor implements KeyListener {

    private BufferedReader reader;

    public NewFileProcessor() {
        File file = new File("C:\\Users\\Мавиле\\Desktop\\file.txt");

        try {
            reader = new BufferedReader(new FileReader(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void startProcessing() {
        File file = new File("C:\\Users\\Мавиле\\Desktop\\file.txt");
        try {
            while (true) {
                String line = reader.readLine();
                if (line == null) {
                    // Если достигнут конец файла, перейти в начало файла и продолжить чтение
                    reader.close();
                    reader = new BufferedReader(new FileReader(file));
                    continue;
                }

                // Обработка каждой строки файла
//                System.out.println(line);

                // Добавьте вашу логику здесь


                Thread.sleep(1000); // Приостановка выполнения на 1 секунду (необязательно)
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        NewFileProcessor fileProcessor = new NewFileProcessor();
        fileProcessor.startProcessing();
    }

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
        // Не используется
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Не используется
    }
}

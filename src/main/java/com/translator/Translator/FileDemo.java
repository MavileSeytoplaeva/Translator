package com.translator.Translator;

import org.apache.tomcat.util.http.fileupload.FileUtils;

import java.io.*;
import java.nio.file.Files;
import java.util.List;

import static java.nio.file.StandardOpenOption.CREATE_NEW;

public class FileDemo {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\Мавиле\\Desktop\\file.txt");
        try (
                FileInputStream fis = new FileInputStream(file);
                BufferedInputStream bis = new BufferedInputStream(fis);
        ) {
            int byteValue;
            while ((byteValue = bis.read()) != -1) {
                System.out.print((char) byteValue);
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}


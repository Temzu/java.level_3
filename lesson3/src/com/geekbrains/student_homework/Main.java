package com.geekbrains.student_homework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        readBytesFromFile("file_t1.txt");
    }

    private static void readBytesFromFile(String fileName) {
        try {
            FileInputStream in = new FileInputStream(fileName);
            byte[] bytes = new byte[50];
            int x;
            while ((x = in.read(bytes)) > 0) {
                for (int i = 0; i < x; i++) {
                    System.out.print(bytes[i] + " ");
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

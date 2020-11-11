package com.geekbrains.student_homework;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
//        readBytesFromFile("file_t1.txt");
//
//        ArrayList<InputStream> inputStreams = new ArrayList<>();
//        try {
//            inputStreams.add(new FileInputStream("file_t2_n1.txt"));
//            inputStreams.add(new FileInputStream("file_t2_n2.txt"));
//            inputStreams.add(new FileInputStream("file_t2_n3.txt"));
//            inputStreams.add(new FileInputStream("file_t2_n4.txt"));
//            inputStreams.add(new FileInputStream("file_t2_n5.txt"));
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        collectManyFilesToOne("file_t2_collected.txt", inputStreams);
    }

    private static void collectManyFilesToOne(String collectedFile, ArrayList<InputStream> inputStreams) {
        try (SequenceInputStream seq = new SequenceInputStream(Collections.enumeration(inputStreams))) {
            FileOutputStream out = new FileOutputStream(collectedFile);
            byte[] bytes = new byte[50];
            int x;
            while ((x = seq.read(bytes)) > 0) {
                for (int i = 0; i < x; i++) {
                    out.write(bytes[i]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
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

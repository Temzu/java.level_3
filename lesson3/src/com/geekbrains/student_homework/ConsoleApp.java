package com.geekbrains.student_homework;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleApp {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static boolean close = false;
    private static ReaderTextFiles readerTextFiles;

    public static void main(String[] args) {
        startApp();

        while (true) {
            String request;
            System.out.println("Select a page to read: ");
            try {
                request = reader.readLine();
                if (request.equals("close")) {
                    close = true;
                    return;
                }
                readerTextFiles.readPage(Integer.parseInt(request));
            } catch (IOException e) {
                e.printStackTrace();
            } catch (NumberFormatException e) {
                System.out.println("You entered an invalid value");
            } finally {
                if (close) {
                    try {
                        reader.close();
                        System.out.println("Application was close");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private static void startApp() {
        System.out.println("The reader application started. To close, enter \"close\".");
        while (true) {
            String request;
            System.out.println("Enter the path to the file: ");
            try {
                request = reader.readLine();
                if (request.equals("close")) {
                    close = true;
                    return;
                }
                readerTextFiles = new ReaderTextFiles(request);
                System.out.println("File was found. Number of pages in file is " + readerTextFiles.getPageCount());
                return;
            } catch (FileNotFoundException e) {
                System.out.println("The file was not found.");
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (close) {
                    try {
                        reader.close();
                        System.out.println("Application was close");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}

package ru.geekbrains.javalevel3.lesson_6;

import java.util.Arrays;

public class MainApp {
    public static void main(String[] args) {
        int[] array = ArrayTransformer.elAfterLast4InArray(3, 4, 5, 6, 7, 4, 6);
        System.out.println(Arrays.toString(array));
    }
}

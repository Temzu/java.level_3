package ru.geekbrains.javalevel3.lesson_6;

import java.util.Arrays;

public class MainApp {
    public static void main(String[] args) {
        int[] array = ArrayHandler.elAfterLast4InArray(3, 4, 5, 6, 7, 4, 6);
        System.out.println(Arrays.toString(array));

        System.out.println(ArrayHandler.check1And4InArr(1, 2, 3 ,4 ,5));
    }
}

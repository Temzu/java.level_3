package ru.geekbrains.student_homework.lesson_5;

import java.util.ArrayList;
import java.util.Arrays;

public class ArraysTransformer {
    public static <T> void swapTwoElOfArray(T[] array, int a, int b) {
        T buf = array[a];
        array[a] = array[b];
        array[b] = buf;
    }

    public static <T> ArrayList<T> transformArrayToArrayList(T[] array) {
        return new ArrayList<>(Arrays.asList(array));
    }
}

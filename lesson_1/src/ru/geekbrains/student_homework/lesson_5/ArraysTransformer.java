package ru.geekbrains.student_homework.lesson_5;

public class ArraysTransformer {
    public static <T> void swapTwoElOfArray(T[] array, int a, int b) {
        T buf = array[a];
        array[a] = array[b];
        array[b] = buf;
    }
}

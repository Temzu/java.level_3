package ru.geekbrains.javalevel3.lesson_6;

import java.util.stream.IntStream;

public class ArrayHandler {
    public static int[] elAfterLast4InArray(int... array) {
        boolean flag = false;
        int lastIndex = 0;
        int[] transformedArr;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 4) {
                flag = true;
                lastIndex = i;
            }
        }
        if (!flag) throw new RuntimeException("The passed array is missing 4");
        transformedArr = new int[array.length - lastIndex - 1];
        System.arraycopy(array, lastIndex + 1, transformedArr, 0, transformedArr.length);
        return transformedArr;
    }

    public static boolean check1And4InArr(int... array) {
        return IntStream.of(array).anyMatch(x -> x == 4 || x == 1);
    }
}

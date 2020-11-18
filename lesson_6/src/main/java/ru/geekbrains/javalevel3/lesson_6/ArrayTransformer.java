package ru.geekbrains.javalevel3.lesson_6;

public class ArrayTransformer {
    public static int[] elAfterLast4InArray(int... ints) {
        boolean flag = false;
        int lastIndex = 0;
        int[] transformedArr;
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] == 4) {
                flag = true;
                lastIndex = i;
            }
        }
        if (!flag) throw new RuntimeException("The passed array is missing 4");
        transformedArr = new int[ints.length - lastIndex - 1];
        System.arraycopy(ints, lastIndex + 1, transformedArr, 0, transformedArr.length);
        return transformedArr;
    }
}

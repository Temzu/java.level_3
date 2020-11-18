package tests;

import org.junit.Assert;
import org.junit.Test;
import ru.geekbrains.javalevel3.lesson_6.ArrayTransformer;

public class ArrayTransformerTest {
    int[] expArr;
    int[] retArr;

    @Test
    public void ArrTransTest_1() {
        retArr = new int[]{1, 2, 3, 4, 5, 6};
        expArr = new int[]{5, 6};
        Assert.assertArrayEquals(expArr, ArrayTransformer.elAfterLast4InArray(retArr));
    }

    @Test
    public void ArrTransTest_2() {
        retArr = new int[]{1, 2, 3, 3, 5, 4};
        expArr = new int[]{};
        Assert.assertArrayEquals(expArr, ArrayTransformer.elAfterLast4InArray(retArr));
    }

    @Test
    public void ArrTransTest_3() {
        retArr = new int[]{4, 1, 2, 3, 3, 6};
        expArr = new int[]{1, 2, 3, 3, 6};
        Assert.assertArrayEquals(expArr, ArrayTransformer.elAfterLast4InArray(retArr));
    }

    @Test(expected = RuntimeException.class)
    public void ArrTransTest_4() {
        retArr = new int[]{1, 1, 2, 3, 3, 6};
        expArr = new int[]{1, 2, 3, 3, 6};
        Assert.assertArrayEquals(expArr, ArrayTransformer.elAfterLast4InArray(retArr));
    }

}

package tests;

import org.junit.Assert;
import org.junit.Test;
import ru.geekbrains.javalevel3.lesson_6.ArrayHandler;

public class ArrayTransformerTest {
    int[] expArr;
    int[] retArr;

    @Test
    public void elAfterLast4InArrayTest_1() {
        retArr = new int[]{1, 2, 3, 4, 5, 6};
        expArr = new int[]{5, 6};
        Assert.assertArrayEquals(expArr, ArrayHandler.elAfterLast4InArray(retArr));
    }

    @Test
    public void elAfterLast4InArrayTest_2() {
        retArr = new int[]{1, 2, 3, 3, 5, 4};
        expArr = new int[]{};
        Assert.assertArrayEquals(expArr, ArrayHandler.elAfterLast4InArray(retArr));
    }

    @Test
    public void elAfterLast4InArrayTest_3() {
        retArr = new int[]{4, 1, 2, 3, 3, 6};
        expArr = new int[]{1, 2, 3, 3, 6};
        Assert.assertArrayEquals(expArr, ArrayHandler.elAfterLast4InArray(retArr));
    }

    @Test(expected = RuntimeException.class)
    public void elAfterLast4InArrayTest_4() {
        retArr = new int[]{1, 1, 2, 3, 3, 6};
        expArr = new int[]{1, 2, 3, 3, 6};
        Assert.assertArrayEquals(expArr, ArrayHandler.elAfterLast4InArray(retArr));
    }

    @Test
    public void check1And4InArrTest_1() {
        Assert.assertTrue(ArrayHandler.check1And4InArr(1, 2, -4, 5, 6));
    }

    @Test
    public void check1And4InArrTest_2() {
        Assert.assertTrue(ArrayHandler.check1And4InArr(2, 2, 4, 5, 6));
    }

    @Test
    public void check1And4InArrTest_3() {
        Assert.assertTrue(ArrayHandler.check1And4InArr(-1, 2, 4, 5, 6));
    }

    @Test
    public void check1And4InArrTest_4() {
        Assert.assertFalse(ArrayHandler.check1And4InArr(0, 2, -4, 5, 6));
    }
}

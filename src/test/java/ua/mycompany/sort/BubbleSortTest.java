package ua.mycompany.sort;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class BubbleSortTest {

    @Test
    public void returnSortedArray() {
        int[] array = new int[]{50, 62, 7, 2, 3};
        int[] arraySorted = new int[]{2, 3, 7, 50, 62};
        new BubbleSort().sort(array);
        assertArrayEquals(arraySorted, array);
    }

    @Test(expected = NullPointerException.class)
    public void throwNullExceptionSortArray() {
        int[] arrayNull = null;
        new BubbleSort().sort(arrayNull);
    }
}
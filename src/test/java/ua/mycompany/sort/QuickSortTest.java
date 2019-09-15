package ua.mycompany.sort;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class QuickSortTest {
    private int[] array;
    private int[] arraySorted;
    private int[] arrayNull;

    @Before
    public void setUp() {
        array = new int[]{50, 62, 7, 2, 3};
        arraySorted = new int[]{2, 3, 7, 50, 62};
        arrayNull = null;
    }

    @Test
    public void returnSortedArray() {
        new QuickSort().sort(array);
        assertArrayEquals(arraySorted, array);
    }

    @Test(expected = NullPointerException.class)
    public void throwNullExceptionSortArray() {
        new QuickSort().sort(arrayNull);
    }
}
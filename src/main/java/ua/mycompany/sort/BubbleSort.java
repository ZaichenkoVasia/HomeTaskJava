package ua.mycompany.sort;

import static ua.mycompany.sort.Helper.swap;

public class BubbleSort implements Sort {

    public void sort(int[] array) {
        if (array == null)
            throw new NullPointerException();
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1])
                    swap(j, j + 1, array);
            }
        }
    }
}

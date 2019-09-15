package ua.mycompany.sort;

import static ua.mycompany.sort.Helper.swap;

public class SelectionSort implements Sort {


    @Override
    public void sort(int[] array) {
        if (array == null)
            throw new NullPointerException();
        for (int left = 0; left < array.length; left++) {
            int minInd = left;
            for (int i = left; i < array.length; i++) {
                if (array[i] < array[minInd]) {
                    minInd = i;
                }
            }
            swap(left, minInd, array);
        }
    }
}

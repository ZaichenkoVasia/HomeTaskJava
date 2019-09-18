package ua.mycompany.sort;

import static ua.mycompany.sort.Helper.swap;

public class QuickSort implements Sort {

    @Override
    public void sort(int[] array) {
            quickSort(0, array.length - 1, array);
    }

    private void quickSort(int low, int high, int[] array) {
        int i = low, j = high;
        int pivot = array[low + (high - low) / 2];

        while (i <= j) {
            while (array[i] < pivot) i++;
            while (array[j] > pivot) j--;
            if (i <= j) {
                swap(i, j, array);
                i++;
                j--;
            }
        }

        if (low < j) quickSort(low, j, array);
        if (high > i) quickSort(i, high, array);
    }
}

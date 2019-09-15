package ua.mycompany.sort;

import static ua.mycompany.sort.Helper.inputArray;
import static ua.mycompany.sort.Helper.outputArray;

public class Main {
    public static void main(String[] args) {
        int[] array = inputArray();
        Sort bubbleSort = new BubbleSort();
        outputArray(bubbleSort, array);

        array = inputArray();
        Sort selectionSort = new SelectionSort();
        outputArray(selectionSort, array);

        array = inputArray();
        Sort quickSort = new QuickSort();
        outputArray(quickSort, array);
    }
}

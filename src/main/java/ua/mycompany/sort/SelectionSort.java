package ua.mycompany.sort;

public class SelectionSort extends Sort {
    public SelectionSort(int[] array) {
        super(array);
    }

    @Override
    protected void sort() {
        if (array == null)
            throw new NullPointerException();
        for (int left = 0; left < array.length; left++) {
            int minInd = left;
            for (int i = left; i < array.length; i++) {
                if (array[i] < array[minInd]) {
                    minInd = i;
                }
            }
            swap(left, minInd);
        }
    }
}
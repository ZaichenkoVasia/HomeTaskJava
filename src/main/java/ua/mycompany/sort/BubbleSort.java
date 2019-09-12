package ua.mycompany.sort;

public class BubbleSort extends Sort {

    public BubbleSort(int[] array) {
        super(array);
    }

    public void sort() {
        if (array == null)
            throw new NullPointerException();
        for (int i = 0; i < this.array.length - 1; i++) {
            for (int j = 0; j < this.array.length - i - 1; j++) {
                if (array[j] > array[j + 1])
                    swap(j, j + 1);
            }
        }
    }
}
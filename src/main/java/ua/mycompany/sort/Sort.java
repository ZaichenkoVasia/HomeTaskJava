package ua.mycompany.sort;

public abstract class Sort {

    protected int[] array;

    public Sort(int[] array) {
        this.array = array;
    }

    public int[] getArray() {
        return array;
    }

    protected abstract void sort();

    protected void swap(int element1, int element2){
        int temp = array[element1];
        array[element1] = array[element2];
        array[element2] = temp;
    }

}

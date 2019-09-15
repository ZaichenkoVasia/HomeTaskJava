package ua.mycompany.sort;

import java.util.Arrays;
import java.util.Random;

public final class Helper {
    private static final int N = 5;

    private Helper() {
    }

    public static int[] inputArray() {
        Random random = new Random();
        int array[] = new int[N];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100);
        }
        return array;
    }

    public static void outputArray(Sort sort, int[] array) {
        System.out.println(Arrays.toString(array));
        sort.sort(array);
        System.out.println(Arrays.toString(array) + "\n");
    }

    public static void swap(int element1, int element2, int[] array) {
        int temp = array[element1];
        array[element1] = array[element2];
        array[element2] = temp;
    }
}

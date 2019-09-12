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

    public static void outputArray(Sort sort) {
        System.out.println(Arrays.toString(sort.getArray()));
        sort.sort();
        System.out.println(Arrays.toString(sort.getArray()) + "\n");
    }
}

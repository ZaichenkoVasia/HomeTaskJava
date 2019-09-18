package ua.mycompany.fibonacci;

public class RecursiveFibonacci implements Fibonacci {
    public RecursiveFibonacci() {
    }

    @Override
    public int getValueFibonacci(int number) {
        if (number < 0) {
            throw new IllegalArgumentException();
        }
        if (number == 0) {
            return 0;
        } else if (number == 1) {
            return 1;
        } else {
            return getValueFibonacci(number - 1) + getValueFibonacci(number - 2);
        }
    }
}

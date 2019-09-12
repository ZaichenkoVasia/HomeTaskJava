package ua.mycompany.fibonacci;

public class NotRecursiveFibonacci implements Fibonacci{
    public NotRecursiveFibonacci() {
    }

    @Override
    public int getValueFibonacci(int number) {
        if(number < 0)
            throw new UnsupportedOperationException();
        int fibonacci1 = 0;
        int fibonacci2 = 1;
        for (int i = 2; i <= number; ++i) {
            int next = fibonacci1 + fibonacci2;
            fibonacci1 = fibonacci2;
            fibonacci2 = next;
        }
        return fibonacci2;
    }
}

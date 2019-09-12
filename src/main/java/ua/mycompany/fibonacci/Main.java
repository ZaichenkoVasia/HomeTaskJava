package ua.mycompany.fibonacci;

public class Main {
    public static void main(String[] args) {
        Fibonacci notRecursiveFibonacci = new NotRecursiveFibonacci();
        Fibonacci recursiveFibonacci = new RecursiveFibonacci();

        System.out.println(notRecursiveFibonacci.getValueFibonacci(4));
        System.out.println(recursiveFibonacci.getValueFibonacci(6));
    }
}

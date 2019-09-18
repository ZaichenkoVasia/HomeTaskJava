package ua.mycompany.fibonacci;

import org.junit.Test;

import static org.junit.Assert.*;

public class RecursiveFibonacciTest {

    @Test
    public void returnRecursiveFibonacciValue() {
        int expected = 8;
        Fibonacci fibonacci = new RecursiveFibonacci();
        int actual = fibonacci.getValueFibonacci(6);
        assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwExceptionIncorrectFibonacci() {
        Fibonacci fibonacci = new NotRecursiveFibonacci();
        fibonacci.getValueFibonacci(-6);
    }
}
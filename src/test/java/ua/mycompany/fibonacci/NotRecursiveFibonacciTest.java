package ua.mycompany.fibonacci;

import org.junit.Test;

import static org.junit.Assert.*;

public class NotRecursiveFibonacciTest {

    @Test
    public void returnNotRecursiveFibonacciValue() {
        int expected = 8;
        Fibonacci fibonacci = new NotRecursiveFibonacci();
        int actual = fibonacci.getValueFibonacci(6);
        assertEquals(expected, actual);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void throwExceptionIncorrectFibonacci() {
        Fibonacci fibonacci = new NotRecursiveFibonacci();
        fibonacci.getValueFibonacci(-6);
    }
}
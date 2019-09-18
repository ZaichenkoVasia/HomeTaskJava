package ua.mycompany.factorial;

import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.*;

public class FactorialTest {

    @Test
    public void returnFactorialBigInteger() {
        BigInteger expected = BigInteger.valueOf(6);
        BigInteger number = BigInteger.valueOf(3);
        BigInteger actual = Factorial.factorial(number);
        assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwExceptionIncorrectFactorial() {
        BigInteger number = BigInteger.valueOf(-3);
        Factorial.factorial(number);
    }
}
package ua.mycompany.factorial;

import java.math.BigInteger;

import static ua.mycompany.factorial.Factorial.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(factorial(BigInteger.valueOf(1000)));
    }
}

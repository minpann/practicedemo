package com.mp.api.function.recursion;

import org.junit.Test;

/**
 * Created by min on 3/6/2017.
 */
public class Fibonacci {

    @Test
    public void fibonacciTest() {
        System.out.print(function(3));
    }

    public int function(int num) {
        if (num == 1 || num == 2) {
            return 1;
        } else {
            return function(num - 1) + function(num - 2);
        }
    }
}

package com.mp.basic;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Created by minpan on 2018/7/21.
 */
public class BasicTest {

    @Test
    public void basicTest() {
        BigInteger num1 = new BigInteger("123638719843568136475882");
        BigInteger value = num1.add(new BigInteger("111")).multiply(new BigInteger("10"));
        System.out.println(value);

        BigDecimal num2 = new BigDecimal("12345.12345678");
        BigDecimal value2 = num2.add(BigDecimal.valueOf(11111.1111));
        System.out.println(value2);
    }
}

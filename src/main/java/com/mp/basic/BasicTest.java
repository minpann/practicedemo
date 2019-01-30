package com.mp.basic;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

/**
 * Created by minpan on 2018/7/21.
 */
public class BasicTest {

    @Test
    public void basicTest() {
//        BigInteger num1 = new BigInteger("123638719843568136475882");
//        BigInteger value = num1.add(new BigInteger("111")).multiply(new BigInteger("10"));
//        System.out.println(value);
//
//        BigDecimal num2 = new BigDecimal("12345.12345678");
//        BigDecimal value2 = num2.add(BigDecimal.valueOf(11111.1111));
//        System.out.println(value2);

        String[] arr = new String[] {"12","23","34","45","56"};
        List<String> list = Arrays.asList(arr);
//        list.stream().forEach((ele) -> System.out.println(ele));
//        list.stream().filter( (ele) -> !ele.contains("3")).limit(2).forEach(ele -> System.out.println(ele));
        String[] arrays = list.toArray(new String[0]);
        System.out.println(arrays);

    }
}

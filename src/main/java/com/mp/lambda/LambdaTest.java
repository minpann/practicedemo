package com.mp.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by minpan on 2018/8/21.
 */
public class LambdaTest {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println("Print all numbers:");
        eval(list, n -> true);
        System.out.println("Print even numbers:");
        eval(list, n -> n % 2 == 0);
        System.out.println("Print numbers greater than 3:");
        eval(list, n -> n > 3);

        list.stream().forEach((i) -> {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        });

        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        List<Integer> squaresList = numbers.stream().map( i -> i*i).distinct().collect(Collectors.toList());
        squaresList.stream().forEach(System.out::println);

        List<String>strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        long count = strings.stream().filter(string -> string.isEmpty()).count();
        System.out.println(count);

        Random random = new Random();
        random.ints().limit(10).forEach(System.out::println);

    }


    public static void eval(List<Integer> list, Predicate<Integer> predicate) {
        for (Integer ele : list) {
            if (predicate.test(ele)) {
                System.out.println(ele + " ");
            }
        }
    }
}

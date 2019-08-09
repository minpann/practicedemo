package com.mp.lambda;

import com.mp.lambda.model.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by minpan on 2019-08-08
 *
 * @author minpan
 */
public class LambdaTest {

    @Test
    public void SteamTest() {
//        List<Person> personList = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            personList.add(Person.builder().age(9-i).name("name" + i).build());
//        }
//
//        List<Person> collect = personList.stream().sorted(new Comparator<Person>() {
//            @Override
//            public int compare(Person o1, Person o2) {
//                return o1.getAge() - o2.getAge();
//            }
//        }).collect(Collectors.toList());
//
//        System.out.println(collect);

//        List<String> list = Arrays.asList("abc", "aaa","abd","abcd");
//        Collections.sort(list,(s1, s2)->s1.compareTo(s2));
//        System.out.println(list);



//        Stream<List<Integer>> stream1 = Stream.of(
//                Arrays.asList(1),
//                Arrays.asList(2, 3),
//                Arrays.asList(4, 5, 6)
//        );
//        Stream<Integer> stream2 = stream1.
//                flatMap((e) -> e.stream());
//
//        stream2.forEach(e->System.out.println(e));//输出1 2 3 4 5 6
        //flatMap 把 stream1 中的层级结构扁平化，就是将最底层元素抽出来放到一起，最终新的 stream2 里面已经没有 List 了，都是直接的数字。

        //例子:
//        Stream<String> stream3 = Stream.of("tom.Li","lucy-Liu");
////flatMap方法把stream1中的每一个字符串都用[.-]分割成了俩个字符串
////最后返回了一个包含4个字符串的stream2
//        Stream<String> stream4 = stream3.flatMap(s->Stream.of(s.split("[.-]")));
//        stream4.forEach(System.out::println);
    }
}

package com.mp.designpattern.builder;

import org.junit.Test;

/**
 * Created by panmin on 16-12-22.
 */
public class BuilderTest {
    @Test
    public void personBuilderTest(){
        System.out.println("person test begin....");
        Person person = new Person.Builder().code(1001).name("王宁").career("IT").address("北京朝阳").build();
        System.out.println(person.toString());
    }
}

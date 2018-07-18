package com.mp.designpattern.singleton;

import org.junit.Test;

/**
 * Created by panmin on 16-12-22.
 */
public class SingletonTest {
    @Test
    public void singletonTest(){
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance1 == instance2);
    }
}

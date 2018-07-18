package com.mp.designpattern.strategy;

import org.junit.Test;

/**
 * Created by panmin on 16-12-22.
 */
public class StrategyTest {
    @Test
    public void strategyTest(){
        MallardDuck mallardDuck = new MallardDuck();
        mallardDuck.swim();
        mallardDuck.perfFly();
        mallardDuck.perfQuack();
        mallardDuck.display();
    }
}

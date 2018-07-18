package com.mp.designpattern.strategy;

import com.mp.designpattern.strategy.impl.FlyWithWings;
import com.mp.designpattern.strategy.impl.Quack;

/**
 * Created by panmin on 16-12-22.
 */
public class MallardDuck extends Duck {
    MallardDuck(){
        flyBehavior = new FlyWithWings();
        quackBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.println("黑色,瘦小...");
    }
}

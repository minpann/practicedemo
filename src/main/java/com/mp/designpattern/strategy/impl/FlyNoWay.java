package com.mp.designpattern.strategy.impl;

import com.mp.designpattern.strategy.FlyBehavior;

/**
 * Created by panmin on 16-12-22.
 */
public class FlyNoWay implements FlyBehavior {

    @Override
    public void fly() {
        System.out.println("不会飞...");
    }
}

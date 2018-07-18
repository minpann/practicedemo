package com.mp.designpattern.strategy.impl;

import com.mp.designpattern.strategy.QuackBehavior;

/**
 * Created by panmin on 16-12-22.
 */
public class MuteQuack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("不会叫...");
    }
}

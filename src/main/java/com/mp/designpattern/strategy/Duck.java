package com.mp.designpattern.strategy;

/**
 * Created by panmin on 16-12-22.
 */
public abstract class Duck {
    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;
    public void swim(){
        System.out.println("会游泳...");
    }
    public abstract void display();

    public void perfFly(){
        flyBehavior.fly();
    }

    public void perfQuack(){
        quackBehavior.quack();
    }
}

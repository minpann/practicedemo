package com.mp.designpattern.observer;

/**
 * Created by minpan on 2018/7/20.
 */
public abstract class Observer {
    protected Subject subject;
    public abstract void update(int state);
}

package com.mp.designpattern.observer;

/**
 * Created by minpan on 2018/7/20.
 */
public class BinaryObserver extends Observer {

    public BinaryObserver(Subject subject) {
        this.subject = subject;
        subject.attach(this);
    }

    @Override
    public void update(int state) {
        System.out.println("Binary String:" + Integer.toBinaryString(state));
    }
}

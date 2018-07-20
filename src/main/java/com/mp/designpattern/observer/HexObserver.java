package com.mp.designpattern.observer;

/**
 * Created by minpan on 2018/7/20.
 */
public class HexObserver extends Observer{
    public HexObserver(Subject subject) {
        this.subject = subject;
        subject.attach(this);
    }

    @Override
    public void update(int state) {
        System.out.println("Hex String:" + Integer.toHexString(state));
    }
}

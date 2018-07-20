package com.mp.designpattern.observer;

/**
 * Created by minpan on 2018/7/20.
 */
public class OctalObserver extends Observer{
    public OctalObserver(Subject subject) {
        this.subject = subject;
        subject.attach(this);
    }

    @Override
    public void update(int state) {
        System.out.println("Octal String:" + Integer.toOctalString(state));
    }
}

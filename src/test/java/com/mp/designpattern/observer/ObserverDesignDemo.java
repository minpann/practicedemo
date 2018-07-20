package com.mp.designpattern.observer;

import org.junit.Test;

/**
 * Created by minpan on 2018/7/20.
 */
public class ObserverDesignDemo {

    @Test
    public void observerDesignTest() {
        Subject subject = new Subject();
        new BinaryObserver(subject);
        new OctalObserver(subject);
        new HexObserver(subject);
        subject.setState(10);
        subject.setState(15);
    }
}

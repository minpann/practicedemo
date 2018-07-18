package com.mp.designpattern.observer;

/**
 * Created by panmin on 16-12-22.
 */
public interface Subject {
    void attach(Observer observer);
    void detach(Observer observer);
    void notice();
}

package com.mp.designpattern.singleton;

/**
 * Created by panmin on 16-12-22.
 */
public class Singleton {
    private static volatile Singleton instance = null;

    private Singleton() {}

    /**
     * double valid
     * @return
     */
    public static Singleton getInstance(){
        if (instance == null)
        {
            synchronized (Singleton.class){
                if (instance == null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}

package com.mp.api.function.lock;

/**
 * Created by min on 2/16/2017.
 */
public class Dog {
    private String name;

    private static Dog instance = null;

    public static Dog getInstance() {
        if (instance == null) {
            synchronized (Dog.class) {
                if ( instance == null) {
                    instance = new Dog();
                }
            }
        }
        return instance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void run(){
        System.out.println(name + " is running...");
    }
    public void bark() {
        System.out.println(name + " is barking...");
    }
}

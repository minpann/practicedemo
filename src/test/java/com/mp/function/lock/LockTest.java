package com.mp.api.function.lock;

import org.junit.Test;

/**
 * Created by min on 2/16/2017.
 */
public class LockTest {
    @Test
    public void LockTest() {
        MyThread myThread1 = new MyThread("tom");
        Thread thread1 = new Thread(myThread1);
        MyThread myThread2 = new MyThread("tony");
        Thread thread2 = new Thread(myThread2);
        thread1.start();
//        try {
//            Thread.sleep(100);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        thread2.start();
    }
}

class MyThread implements Runnable{
    private String threadName;
    Dog dog ;
    MyThread () {}

    MyThread(String threadName){
        this.threadName = threadName;
    }

    @Override
    public void run() {
        System.out.println( this.threadName + " doing something...");
        dog = Dog.getInstance();
        dog.setName(threadName);
        dog.run();
        dog.bark();
    }
}




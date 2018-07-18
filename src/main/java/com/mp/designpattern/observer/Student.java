package com.mp.designpattern.observer;

/**
 * Created by panmin on 16-12-22.
 */
public class Student implements Observer {
    private String name;
    private String phone;
    private Teacher teacher;

    public Student(String name, Teacher teacher){
        this.name = name;
        this.teacher = teacher;
    }

    @Override
    public void update() {
        this.phone = teacher.getPhone();
    }

    public void show() {
        System.out.println("phone: " + phone);
    }
}

package com.mp.designpattern.observer;

import java.util.Vector;

/**
 * Created by panmin on 16-12-22.
 */
public class Teacher implements Subject {
    private String name;
    private Vector students;
    private String phone;

    public Teacher() {
        this.phone = "";
        students = new Vector();
    }

    @Override
    public void attach(Observer observer) {
        students.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        students.remove(observer);
    }

    @Override
    public void notice() {
        for (int i = 0; i < students.size(); i++) {
            ((Observer) students.get(i)).update();
        }
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
        notice();
    }
}

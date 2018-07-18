package com.mp.designpattern.observer;

import org.junit.Test;

import java.util.Vector;

/**
 * Created by panmin on 16-12-22.
 */
public class ObserverTest {
    @Test
    public void observerTest() {
        Vector students = new Vector();
        Teacher teacher = new Teacher();
        for (int i = 0; i < 10; i++) {
            Student student = new Student("王明" + i, teacher);
            students.add(student);
            teacher.attach(student);
        }

        teacher.setPhone("88803807");
        for (int i = 0; i < 10; i++)
            ((Student) students.get(i)).show();
        teacher.setPhone("88808880");
        for (int i = 0; i < 10; i++)
            ((Student) students.get(i)).show();
    }
}

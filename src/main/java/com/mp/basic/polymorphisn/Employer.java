package com.mp.basic.polymorphisn;

/**
 * Created by min on 7/23/2018.
 */
public class Employer {
    private String name;
    private Integer salary;

    public Employer() {
    }

    public Employer(String name, Integer salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Integer getSalary() {
        return salary;
    }
}

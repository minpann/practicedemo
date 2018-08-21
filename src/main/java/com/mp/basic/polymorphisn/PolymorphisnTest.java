package com.mp.basic.polymorphisn;

/**
 * Created by min on 7/23/2018.
 */
public class PolymorphisnTest {
    public static void main(String[] args) {
        Employer employer1 = new Employer("小张", 10000);
        System.out.println("name:" + employer1.getName() + " salary:" + employer1.getSalary());

        Employer employer = new Manager("王明", 5000, 5000);
        System.out.println("name:" + employer.getName() + " salary:" + employer.getSalary());

        Manager manager = (Manager) employer;
        System.out.println("name:" + manager.getName() + " allowance:" + manager.getAllowance() + " salary:" + manager.getSalary());

    }
}

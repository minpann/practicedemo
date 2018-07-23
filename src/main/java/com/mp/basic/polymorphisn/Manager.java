package com.mp.basic.polymorphisn;

/**
 * Created by min on 7/23/2018.
 */
public class Manager extends Employer {
    private Integer allowance;

    public Manager(String name, Integer salary, Integer allowance) {
        super(name, salary);
        this.allowance = allowance;
    }

    public Integer getSalary() {
        return 2 * super.getSalary() + allowance;
    }

    public Integer getAllowance() {
        return allowance;
    }

    public void setAllowance(Integer allowance) {
        this.allowance = allowance;
    }
}

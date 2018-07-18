package com.mp.compare;

import java.util.Arrays;

public class MyCompareTest {
	public static void main(String[] args) {
		Employee[] emp = new Employee[3];
		
		emp[0] = new Employee(1, "王明", "北京");
		emp[1] = new Employee(4, "李成", "上海");
		emp[2] = new Employee(3, "将兵", "广州");
		
		Arrays.sort(emp);
		
		for (Employee employee : emp) {
			System.out.println(employee.toString());
			System.out.print(employee.getId() + " " +employee.getName() + " " + employee.getAddress());
			System.out.println();
		}
	}
}

package com.mp.compare;

public class Employee implements Comparable<Employee>{

	private int id ;
	private String name;
	private String address;
	
	public Employee(int id, String name, String address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public int compareTo(Employee obj) {
		if(this.id - obj.getId() > 0)
		{
			return 1;
		}else if(this.id - obj.getId() == 0){
			return 0;
		}else{
			return -1;
		}
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", address=" + address
				+ "]";
	}
}

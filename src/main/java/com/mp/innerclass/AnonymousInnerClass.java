package com.mp.innerclass;

interface Person
{
	public void run();
}

public class AnonymousInnerClass {
	public static void main(String[] args) {
		Person p = new Person() {
			
			@Override
			public void run() {
				System.out.println("AnonymousInnerClass run...");
			}
		};
		p.run();
	}
	
}

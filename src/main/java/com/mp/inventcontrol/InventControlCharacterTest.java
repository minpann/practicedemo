package com.mp.inventcontrol;

public class InventControlCharacterTest{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Base b = new Base();
		Base b1 = new Child();
		Child c = new Child();
		System.out.println(b.pro);
		System.out.println(b.pub);
		System.out.println(b.getPri());
		System.out.println(b.getPro());
		System.out.println(b.getPub());
		System.out.println(((Child)b1).pro);
		System.out.println(((Child)b1).pub);
		System.out.println(b1.getPri());
		System.out.println(b1.getPro());
		System.out.println(b1.getPub());
		System.out.println(c.pro);
		System.out.println(c.pub);
		System.out.println("-------- ----------------");
		b1.setPri1(7);
		System.out.println(b1.getPri1());
		System.out.println("------------------------");
		b1.setPri(10);
		System.out.println(b1.getPri());
		System.out.println(((Child)b1).getPri());
		
	}

}

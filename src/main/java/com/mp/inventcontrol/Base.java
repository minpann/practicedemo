package com.mp.inventcontrol;

public class Base {

	private int pri;
	protected int pro;
	public int pub;
	private int pri1;

	public Base()
	{
		this.pri = 1;
		this.pro = 2;
		this.pub = 3;
		this.pri1 =31;
	};

	public Base(int pri, int pro, int pub) {
		super();
		this.pri = pri;
		this.pro = pro;
		this.pub = pub;
	}
	
	public int getPri1() {
		return pri1;
	}
	
	public void setPri1(int pri1) {
		this.pri1 = pri1;
	}
	
	public int getPri() {
		return pri;
	}
	public void setPri(int pri) {
		this.pri = pri;
	}
	public int getPro() {
		return pro;
	}
	public void setPro(int pro) {
		this.pro = pro;
	}
	public int getPub() {
		return pub;
	}
	public void setPub(int pub) {
		this.pub = pub;
	}

}

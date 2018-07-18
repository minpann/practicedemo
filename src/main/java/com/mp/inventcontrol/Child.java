package com.mp.inventcontrol;

public class Child extends Base{

	private int pri;
	protected int pro;
	public int pub;
	
	public Child()
	{
		this.pri = 4;
		this.pro = 5;
		this.pub = 6;
	}
	
	public Child(int pri, int pro, int pub, int pri2, int pro2, int pub2) {
		super(pri, pro, pub);
		pri = pri2;
		pro = pro2;
		pub = pub2;
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

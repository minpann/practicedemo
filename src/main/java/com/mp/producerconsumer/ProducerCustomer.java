package com.mp.producerconsumer;

import java.util.LinkedList;

public class ProducerCustomer {
	
	public static int MAXSIZE = 10;

	private LinkedList<Object> storeProduct = new LinkedList<Object>(); 
	
	public void start()
	{
		new Producter().start();
		new Customer().start();
	}
	
	class Producter extends Thread
	{
		@Override
		public void run() {
			while(true)
			{
				synchronized (storeProduct){
					try {
						if(storeProduct.size() == MAXSIZE)
						{
							System.out.println("the storeProduct is full please wait!");
							storeProduct.wait();
						}
						Object obj = new Object();
						storeProduct.add(obj);
						Thread.sleep((long)(Math.random()*2000));
						System.out.println("Produce a Product and the number is:" + storeProduct.size());
						storeProduct.notify();
					} catch (InterruptedException e) {
						System.out.println("product is Interrupted!");
					}
				}
			}
			
		}
		
	}
	
	class Customer extends Thread
	{
		@Override
		public void run() {
			while(true)
			{
				synchronized (storeProduct){
					try {
						if(storeProduct.size() == 0)
						{
							System.out.println("the storeProduct is Empty please wait!");
							storeProduct.wait();
						}
						storeProduct.removeLast();
						System.out.println("comsume a Product and the number is:" + storeProduct.size());
						Thread.sleep((long)(Math.random()*2000));
						storeProduct.notify();
					} catch (InterruptedException e) {
						System.out.println("product is Interrupted!");
					}
				}
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		ProducerCustomer pc = new ProducerCustomer();
		pc.start();
	}
	
}

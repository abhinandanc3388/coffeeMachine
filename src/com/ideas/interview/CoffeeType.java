package com.ideas.interview;

public enum CoffeeType {
	BLACK(10),MILK(20);
	
	private int price;
	
	 CoffeeType(int price) {
		this.price=price;
	}
	 
	 int getPrice() {
	      return price;
	   } 
}

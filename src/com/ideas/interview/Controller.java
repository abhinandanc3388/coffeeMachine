package com.ideas.interview;

public class Controller {
	private final Display display;
	private final Barista barista;
	private CoffeeType coffeeType;
	private Integer price;
	private Casheer person;
	private Boolean payment_flag= false;

	public Controller(Display display, Barista barista,Casheer person) {
		this.display = display;
		this.barista = barista;
		this.person = person;
	//	this.price=price;
		display.show("Please select a coffee type");
	}

	public void userWants(CoffeeType coffeeType) {
		this.coffeeType = coffeeType;
		Integer coffeePrice = getCoffeePrice(coffeeType);
		this.price=coffeePrice;
		display.show("Great Choice! please pay "+coffeePrice+" Rs");
	}
	
	public Integer getCoffeePrice(CoffeeType coffeeType) {
		
		CoffeeType[] values = CoffeeType.values();
		int price = values[0].getPrice();
		return price;
		//display.show("Your selected Coffee price is "+this.price+" ,please pay it.");
		
	}
	
	public void acceptPayment(Integer price) {
		
		
		
		if(this.price == price) {
			person.setPayment(price);
			display.show("Great You have done the payment!");
			payment_flag=true;
		}else {
			
			display.show("You have done wrong payment amount, please give proper amount!");
		}
		
	}

	public void dispense() {
		if(this.payment_flag = true) {
			barista.serve(coffeeType);
			display.show("Please collect your delicious coffee");	
		}else {
			display.show("Please do the payment first");	
		}
		
	}
}

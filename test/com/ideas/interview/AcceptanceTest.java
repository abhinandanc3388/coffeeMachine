package com.ideas.interview;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AcceptanceTest {

	private Controller controller;
	private Display display;
	private Barista barista;
	private Casheer person;
	

	@Test
	public void dispenseBlackCoffeeForPaidSuccessfulPayment() {
		powerUp();
		assertEquals("Please select a coffee type", display.currentMessage());
		userWants(CoffeeType.BLACK);
		assertEquals("Great Choice! please pay 10 Rs", display.currentMessage());
	//	Integer price=getCoffeePrice(CoffeeType.BLACK);
		acceptPayment(10);
		assertEquals("Great You have done the payment!", display.currentMessage());
		controller.dispense();
		assertEquals(CoffeeType.BLACK, barista.servedCoffee());
		assertEquals("Please collect your delicious coffee", display.currentMessage());
	}
	
	@Test
	public void dispenseBlackCoffeeForPaidFailurePayemnt() {
		powerUp();
		assertEquals("Please select a coffee type", display.currentMessage());
		userWants(CoffeeType.BLACK);
		assertEquals("Great Choice! please pay 10 Rs", display.currentMessage());
	//	Integer price=getCoffeePrice(CoffeeType.BLACK);
		acceptPayment(5);
		assertEquals("You have done wrong payment amount, please give proper amount!", display.currentMessage());
		controller.dispense();
		assertEquals(CoffeeType.BLACK, barista.servedCoffee());
		assertEquals("Please do the payment first", display.currentMessage());
	}
	
	private void acceptPayment(Integer price) {
		
		controller.acceptPayment(price);
		
	}

	private Integer getCoffeePrice(CoffeeType black) {
		
		return controller.getCoffeePrice(black);
	}

	/*
	 * @Test public void dispenseMilkCoffeeForFree() { powerUp();
	 * assertEquals("Please select a coffee type ,Each Coffee is of 10 RS",
	 * display.currentMessage()); userWants(CoffeeType.MILK);
	 * assertEquals("Great Choice!", display.currentMessage());
	 * controller.dispense(); assertEquals(CoffeeType.MILK, barista.servedCoffee());
	 * assertEquals("Please collect your delicious coffee",
	 * display.currentMessage()); }
	 */

	private AcceptanceTest userWants(CoffeeType coffeeType) {
		controller.userWants(coffeeType);
		return this;
	}

	private void powerUp() {
		display = new Display();
		barista = new Barista();
		 person = new Casheer();
		//paidCoffee = new PaidCoffee();
		controller = new Controller(display, barista,person);
	}
}

package com.techelevator;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

import junit.framework.Assert;

public class DrinkTest {

	Drink drink = new Drink("Monster", BigDecimal.valueOf(2.00), "A3");
	
	@Test
	public void getTypeReturnsDrink() {
		String expected = "Drink";
		String actual = drink.getType();
		assertEquals(expected, actual);
	}
	
	@Test
	public void getPurchaseMessageReturnsMessage() {
		String expected = "Glug Glug, Yum!";
		String actual = drink.getPurchaseMessage();
		assertEquals(expected, actual);
	}
	
	@Test
	public void getNameReturnsName() {
		String expected = "Monster";
		String actual = drink.getName();
		assertEquals(expected, actual);
	}
	
	@Test
	public void getPriceReturnsPrice() {
		BigDecimal expected = BigDecimal.valueOf(2.00);
		BigDecimal actual = drink.getPrice();
		assertEquals(expected, actual);
	}
	
	@Test
	public void getSlotIdentierReturnsSI() {
		String expected = "A3";
		String actual = drink.getSlotIdentifier();
		assertEquals(expected, actual);
	}
	
	@Test
	public void getStockReturns5() {
		Integer expected = 5;
		Integer actual = drink.getStock();
		assertEquals(expected, actual);
	}
	
	@Test
	public void setStockto0Returns0() {
		drink.setStock(0);
		Integer expected = 0;
		Integer actual = drink.getStock();
		assertEquals(expected, actual);
	}
	
	@Test
	public void setStockto6Returns5() {
		drink.setStock(6);
		Integer expected = 5;
		Integer actual = drink.getStock();
		assertEquals(expected, actual);
	}
	
	@Test
	public void setStocktoNeg1Returns5() {
		drink.setStock(-1);
		Integer expected = 5;
		Integer actual = drink.getStock();
		assertEquals(expected, actual);
	}

}

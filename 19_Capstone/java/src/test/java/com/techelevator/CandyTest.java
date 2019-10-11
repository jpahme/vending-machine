package com.techelevator;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

import junit.framework.Assert;

public class CandyTest {

	Candy candy = new Candy("Snickers", BigDecimal.valueOf(2.00), "A3");
	
	@Test
	public void getTypeReturnsCandy() {
		String expected = "Candy";
		String actual = candy.getType();
		assertEquals(expected, actual);
	}
	
	@Test
	public void getPurchaseMessageReturnsMessage() {
		String expected = "Munch Much, Yum!";
		String actual = candy.getPurchaseMessage();
		assertEquals(expected, actual);
	}
	
	@Test
	public void getNameReturnsName() {
		String expected = "Snickers";
		String actual = candy.getName();
		assertEquals(expected, actual);
	}
	
	@Test
	public void getPriceReturnsPrice() {
		BigDecimal expected = BigDecimal.valueOf(2.00);
		BigDecimal actual = candy.getPrice();
		assertEquals(expected, actual);
	}
	
	@Test
	public void getSlotIdentierReturnsSI() {
		String expected = "A3";
		String actual = candy.getSlotIdentifier();
		assertEquals(expected, actual);
	}
	
	@Test
	public void getStockReturns5() {
		Integer expected = 5;
		Integer actual = candy.getStock();
		assertEquals(expected, actual);
	}
	
	@Test
	public void setStockto0Returns0() {
		candy.setStock(0);
		Integer expected = 0;
		Integer actual = candy.getStock();
		assertEquals(expected, actual);
	}
	
	@Test
	public void setStockto6Returns5() {
		candy.setStock(6);
		Integer expected = 5;
		Integer actual = candy.getStock();
		assertEquals(expected, actual);
	}
	
	@Test
	public void setStocktoNeg1Returns5() {
		candy.setStock(-1);
		Integer expected = 5;
		Integer actual = candy.getStock();
		assertEquals(expected, actual);
	}

}

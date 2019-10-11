package com.techelevator;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

import junit.framework.Assert;

public class GumTest {

	Gum gum = new Gum("Orbit", BigDecimal.valueOf(2.00), "A3");
	
	@Test
	public void getTypeReturnsGum() {
		String expected = "Gum";
		String actual = gum.getType();
		assertEquals(expected, actual);
	}
	
	@Test
	public void getPurchaseMessageReturnsMessage() {
		String expected = "Chew Chew, Yum!";
		String actual = gum.getPurchaseMessage();
		assertEquals(expected, actual);
	}
	
	@Test
	public void getNameReturnsName() {
		String expected = "Orbit";
		String actual = gum.getName();
		assertEquals(expected, actual);
	}
	
	@Test
	public void getPriceReturnsPrice() {
		BigDecimal expected = BigDecimal.valueOf(2.00);
		BigDecimal actual = gum.getPrice();
		assertEquals(expected, actual);
	}
	
	@Test
	public void getSlotIdentierReturnsSI() {
		String expected = "A3";
		String actual = gum.getSlotIdentifier();
		assertEquals(expected, actual);
	}
	
	@Test
	public void getStockReturns5() {
		Integer expected = 5;
		Integer actual = gum.getStock();
		assertEquals(expected, actual);
	}
	
	@Test
	public void setStockto0Returns0() {
		gum.setStock(0);
		Integer expected = 0;
		Integer actual = gum.getStock();
		assertEquals(expected, actual);
	}
	
	@Test
	public void setStockto6Returns5() {
		gum.setStock(6);
		Integer expected = 5;
		Integer actual = gum.getStock();
		assertEquals(expected, actual);
	}
	
	@Test
	public void setStocktoNeg1Returns5() {
		gum.setStock(-1);
		Integer expected = 5;
		Integer actual = gum.getStock();
		assertEquals(expected, actual);
	}

}
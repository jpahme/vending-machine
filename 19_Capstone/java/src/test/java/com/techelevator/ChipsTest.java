package com.techelevator;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

import junit.framework.Assert;

public class ChipsTest {

	Chips chips = new Chips("Lays", BigDecimal.valueOf(2.00), "A3");
	
	@Test
	public void getTypeReturnsChips() {
		String expected = "Chips";
		String actual = chips.getType();
		assertEquals(expected, actual);
	}
	
	@Test
	public void getPurchaseMessageReturnsMessage() {
		String expected = "Crunch Crunch, Yum!";
		String actual = chips.getPurchaseMessage();
		assertEquals(expected, actual);
	}
	
	@Test
	public void getNameReturnsName() {
		String expected = "Lays";
		String actual = chips.getName();
		assertEquals(expected, actual);
	}
	
	@Test
	public void getPriceReturnsPrice() {
		BigDecimal expected = BigDecimal.valueOf(2.00);
		BigDecimal actual = chips.getPrice();
		assertEquals(expected, actual);
	}
	
	@Test
	public void getSlotIdentierReturnsSI() {
		String expected = "A3";
		String actual = chips.getSlotIdentifier();
		assertEquals(expected, actual);
	}
	
	@Test
	public void getStockReturns5() {
		Integer expected = 5;
		Integer actual = chips.getStock();
		assertEquals(expected, actual);
	}
	
	@Test
	public void setStockto0Returns0() {
		chips.setStock(0);
		Integer expected = 0;
		Integer actual = chips.getStock();
		assertEquals(expected, actual);
	}
	
	@Test
	public void setStockto6Returns5() {
		chips.setStock(6);
		Integer expected = 5;
		Integer actual = chips.getStock();
		assertEquals(expected, actual);
	}
	
	@Test
	public void setStocktoNeg1Returns5() {
		chips.setStock(-1);
		Integer expected = 5;
		Integer actual = chips.getStock();
		assertEquals(expected, actual);
	}

}

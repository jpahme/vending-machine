package com.techelevator;

import java.math.BigDecimal;

public class Drink extends VendingMachineItem {
	private final static String type = "Drink";
	private final static String purchaseMessage = "Glug Glug, Yum!";

	public Drink(String name, BigDecimal price, String slotIdentifier) {
		super(name, price, slotIdentifier);
	}
	public String getType() {
		return type;
	}

	public String getPurchaseMessage() {
		return purchaseMessage;
	}


}

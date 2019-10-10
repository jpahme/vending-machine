package com.techelevator;

import java.math.BigDecimal;

public class Chips extends VendingMachineItem {
	private final static String type = "Chips";
	private final static String purchaseMessage = "Crunch Crunch, Yum!";

	public Chips(String name, BigDecimal price, String slotIdentifier) {
		super(name, price, slotIdentifier);
	}
	public static String getType() {
		return type;
	}

	public static String getPurchasemessage() {
		return purchaseMessage;
	}


}

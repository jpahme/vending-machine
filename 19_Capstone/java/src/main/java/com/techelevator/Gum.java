package com.techelevator;

import java.math.BigDecimal;

public class Gum extends VendingMachineItem {
	private final static String type = "Gum";
	private final static String purchaseMessage = "Chew Chew, Yum!";

	public Gum(String name, BigDecimal price, String slotIdentifier) {
		super(name, price, slotIdentifier);
	}
	public String getType() {
		return type;
	}

	public String getPurchaseMessage() {
		return purchaseMessage;
	}


}

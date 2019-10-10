package com.techelevator;

import java.math.BigDecimal;

public class Candy extends VendingMachineItem {
	private final static String type = "Candy";
	private final static String purchaseMessage = "Munch Much, Yum!";

	public Candy(String name, BigDecimal price, String slotIdentifier) {
		super(name, price, slotIdentifier);
	}
	public static String getType() {
		return type;
	}

	public static String getPurchasemessage() {
		return purchaseMessage;
	}


}

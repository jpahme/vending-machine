
package com.techelevator.view;

import java.io.InputStream;
import java.io.OutputStream;

public class PurchaseMenu extends Menu {

	private static final String purchaseMenuOptionFeedMoney = "Feed Money";
	private static final String purchaseMenuOptionSelectProduct = "Select Product";
	private static final String purchaseMenuOptionFinishTransaction = "Finish Transaction";
	private static final String[] purchaseMenuOptions = { purchaseMenuOptionFeedMoney, purchaseMenuOptionSelectProduct,
			purchaseMenuOptionFinishTransaction };

	public PurchaseMenu(InputStream input, OutputStream output) {
		super(input, output);
	}

	public static String[] getPurchaseMenuOptions() {
		return purchaseMenuOptions;
	}
	
	
	
	
}

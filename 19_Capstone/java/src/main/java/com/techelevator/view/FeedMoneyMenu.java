package com.techelevator.view;

import java.io.InputStream;
import java.io.OutputStream;

public class FeedMoneyMenu extends Menu {
	
	private static final String feedMoneyMenuOneDollar = "$1";
	private static final String feedMoneyMenuTwoDollars = "$2";
	private static final String feedMoneyMenuFiveDollars = "$5";
	private static final String feedMoneyMenuTenDollars = "$10";
	private static final String[] feedMoneyMenuOptions = { feedMoneyMenuOneDollar, feedMoneyMenuTwoDollars, feedMoneyMenuFiveDollars, feedMoneyMenuTenDollars };
	
	public FeedMoneyMenu(InputStream input, OutputStream output) {
		super(input, output);
	}
	
	public static String[] getFeedMoneyMenuOptions() {
		return feedMoneyMenuOptions;
	}

}
	


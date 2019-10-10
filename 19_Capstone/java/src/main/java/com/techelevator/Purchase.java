package com.techelevator;

import com.techelevator.view.FeedMoneyMenu;
import com.techelevator.view.Menu;

public class Purchase {
	
	public void feedMoney(Menu menu) {
		String[] feedMoneyMenu = FeedMoneyMenu.getFeedMoneyMenuOptions();
		String choice = (String) menu.getChoiceFromOptions(feedMoneyMenu);
	}
	
	public void selectProduct() {
		
	}
	
	public void dispense() {
		
	}

}

package com.techelevator;

import java.math.BigDecimal;

import com.techelevator.view.FeedMoneyMenu;
import com.techelevator.view.Menu;

public class Purchase {

	private static BigDecimal currentMoney = new BigDecimal(0);

	public static BigDecimal getCurrentMoney() {
		return currentMoney.setScale(2, BigDecimal.ROUND_UP);
	}

	public static void addToCurrentMoney(BigDecimal amountToAdd) {
		currentMoney = currentMoney.add(amountToAdd).setScale(2, BigDecimal.ROUND_UP);
	}
	
	public static void subtractFromCurrentMoney(BigDecimal amountToSubtract) {
		currentMoney = currentMoney.subtract(amountToSubtract).setScale(2, BigDecimal.ROUND_UP);
	}

	public void feedMoney(Menu menu) {
		String[] feedMoneyMenu = FeedMoneyMenu.getFeedMoneyMenuOptions();
		String choice = (String) menu.getChoiceFromOptions(feedMoneyMenu);
		if (choice.equals("$1")) {
			Purchase.addToCurrentMoney(BigDecimal.valueOf(1));
		}
		else if(choice.equals("$2")) {
			Purchase.addToCurrentMoney(BigDecimal.valueOf(2));
		}
		else if(choice.equals("$5")) {
			Purchase.addToCurrentMoney(BigDecimal.valueOf(5));
		}
		else if(choice.equals("$10")) {
			Purchase.addToCurrentMoney(BigDecimal.valueOf(10));
		}
		else {
			System.out.println("Invalid choice");
		}

	}

	public void selectProduct() {

	}

	public void dispense() {

	}

}

package com.techelevator;

import java.math.BigDecimal;
import java.util.Scanner;

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
		BigDecimal amountToFeed = new BigDecimal(0);
		if (choice.equals("$1")) {
			amountToFeed = BigDecimal.valueOf(1).setScale(2, BigDecimal.ROUND_UP);
		}
		else if(choice.equals("$2")) {
			amountToFeed = BigDecimal.valueOf(2).setScale(2, BigDecimal.ROUND_UP);
		}
		else if(choice.equals("$5")) {
			amountToFeed = BigDecimal.valueOf(5).setScale(2, BigDecimal.ROUND_UP);
		}
		else if(choice.equals("$10")) {
			amountToFeed = BigDecimal.valueOf(10).setScale(2, BigDecimal.ROUND_UP);
		}
		else {
			System.out.println("Invalid choice");
			return;
		}
		Purchase.addToCurrentMoney(amountToFeed);
		Log.logFeedMoney(amountToFeed);

	}

	public void selectProduct(VendingMachineInventory inventory) {
		inventory.printInventory();
		Scanner input = new Scanner(System.in);
		String userInput = input.nextLine();
		for(VendingMachineItem item : inventory.getVendingMachineInventory()) {
			if(userInput.equals(item.getSlotIdentifier())) {
				if (item.getStock() == 0) {
					System.out.println("SOLD OUT");
				}
				else {
					dispense(item);
				}
				return;
			}
		}
		System.out.println("Invalid Selection");
		

	}

	public void dispense(VendingMachineItem selection) {
		String productName = selection.getName();
		BigDecimal productCost = selection.getPrice();
		Purchase.subtractFromCurrentMoney(productCost);
		BigDecimal remainingMoney = Purchase.getCurrentMoney();
		subtractOneFromStock(selection);
		System.out.println("Dispensing: " + productName + " $" + productCost + " $" + remainingMoney);
		System.out.println(selection.getPurchaseMessage());
	}
	
	public void subtractOneFromStock(VendingMachineItem item) {
		Integer currentStock = item.getStock();
		Integer purchasedItem = 1;
		item.setStock(currentStock - purchasedItem);
	}
	
	public void finishTransaction() {
		ChangeCalculator.calculateChange(getCurrentMoney());
		resetCurrentMoney();
	}
	
	public void resetCurrentMoney() {
		currentMoney = BigDecimal.ZERO;
		
	}

}

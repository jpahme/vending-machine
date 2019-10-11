package com.techelevator;

import com.techelevator.view.FeedMoneyMenu;
import com.techelevator.view.Menu;
import com.techelevator.view.PurchaseMenu;

public class VendingMachineCLI {
	
	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT};

	private Menu menu;

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void run(VendingMachineInventory inventory, Purchase purchase) {
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				inventory.printInventory();
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				goToPurchaseMenu(choice, purchase, inventory);
				}
			else if(choice.equals(MAIN_MENU_OPTION_EXIT)) {
				System.out.println("Thank you for your purchase!");
				System.exit(0);
			}
		}
	}

	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		VendingMachineInventory vendingMachineInventory = new VendingMachineInventory();
		vendingMachineInventory.createInventory();
		Purchase purchase = new Purchase();
		cli.run(vendingMachineInventory, purchase);
	}
	
	public void goToPurchaseMenu(String choice, Purchase purchase, VendingMachineInventory inventory) {
		boolean purchasing = true;
		while(purchasing) {
			String[] purchaseMenuOptions = PurchaseMenu.getPurchaseMenuOptions();
			choice = (String) menu.getChoiceFromOptions(purchaseMenuOptions);
			if(choice.equals("Feed Money")) {
				purchase.feedMoney(menu);
			}
			else if(choice.equals("Select Product")) {
				purchase.selectProduct(inventory);
			}
			else if(choice.equals("Finish Transaction")) {
				purchase.finishTransaction();
				purchasing = false;
			}
		}
	}
}

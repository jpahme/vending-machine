package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VendingMachineInventory {
	private List <VendingMachineItem> vendingMachineInventory = new ArrayList<>();

	public List <VendingMachineItem> getVendingMachineInventory() {
		return vendingMachineInventory;
	}
	
	public void createInventory() {
		File inputFile = new File("vendingmachine.csv");
		try {
			Scanner inputScanner = new Scanner(inputFile);
			while(inputScanner.hasNextLine()) {
				String lineInput = inputScanner.nextLine();
				String[] itemLine = lineInput.split("\\|");
				String slotIdentifier = itemLine[0];
				String itemName = itemLine[1];
				double price = Double.parseDouble(itemLine[2]);
				BigDecimal itemPrice = new BigDecimal(price);
				itemPrice = itemPrice.setScale(2, BigDecimal.ROUND_UP);
				if(itemLine[3].equals("Chip")) {
					vendingMachineInventory.add(new Chips(itemName, itemPrice, slotIdentifier));
				}
				else if (itemLine[3].equals("Gum")) {
					vendingMachineInventory.add(new Gum(itemName, itemPrice, slotIdentifier));
				}
				else if (itemLine[3].equals("Drink")) {
					vendingMachineInventory.add(new Drink(itemName, itemPrice, slotIdentifier));
				}
				else if (itemLine[3].equals("Candy")) {
					vendingMachineInventory.add(new Candy(itemName, itemPrice, slotIdentifier));
				}
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
		}
		
	}
	
	public void printInventory() {
		System.out.println("");
		for (VendingMachineItem item : vendingMachineInventory) {
			String slotIdentifier = item.getSlotIdentifier();
			String itemName = item.getName();
			String price = item.getPrice().toString();
			String stock = item.getStock().toString();
			if (item.getStock() == 0) {
				stock = "SOLD OUT";
			}
			System.out.println(slotIdentifier + " " + itemName + " $" + price + " " + stock);
		}
	}
	
	
	
	

}



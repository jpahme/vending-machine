package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class VendingMachineInventory {
	private List <VendingMachineItem> vendingMachineInventory;

	public List <VendingMachineItem> getVendingMachineInventory() {
		return vendingMachineInventory;
	}

	public void setVendingMachineInventory(List <VendingMachineItem> vendingMachineInventory) {
		this.vendingMachineInventory = vendingMachineInventory;
	}
	
	public void createInventory() {
		File inputFile = new File("vendingmachine.csv");
		try {
			Scanner inputScanner = new Scanner(inputFile);
			while(inputScanner.hasNextLine()) {
				String lineInput = inputScanner.nextLine();
				String[] itemLine = lineInput.split("|");
				String slotIdentifier = itemLine[0];
				String itemName = itemLine[1];
				BigDecimal price = new BigDecimal(Integer.parseInt(itemLine[2]));
				if(itemLine[3].equals("Chip")) {
					VendingMachineItem = new VendingMachineItem();
				}
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
		}
		
	}

}


// A1|Potato Crisps|3.05|Chip
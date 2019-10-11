package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Log {

	private static File outputFile = new File("Log.txt");
	private static PrintWriter writer = null;
	private static Date currentDateAndTime;
	private static SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a");

	public static void openLog() throws IOException {

		if (outputFile.exists())
			System.out.println("File exists");
		if (!outputFile.exists()) { 
			System.out.println("Creating new file");
			outputFile.createNewFile();

		}	
		writer = new PrintWriter(new FileOutputStream(outputFile, true));
	}

	public static void logFeedMoney(BigDecimal amountFed) throws IOException {
		openLog();
		System.out.println(writer.toString());
		currentDateAndTime = new Date();
		String logMessage = " FEED MONEY: ";
		String logFedAmount = amountFed.toString();
		String logCurrentMoney = Purchase.getCurrentMoney().toString();
		String feedMoneyLog = dateFormat.format(currentDateAndTime) + logMessage + "$" + logFedAmount + " $"
				+ logCurrentMoney + "\n";
		writer.append(feedMoneyLog);
		writer.flush();
		writer.close();
		
	}

	public static void logPurchase(VendingMachineItem purchasedItem) throws IOException {
		openLog();
		currentDateAndTime = new Date();
		String purchasedItemName = purchasedItem.getName();
		String logCurrentMoney = Purchase.getCurrentMoney().toString();
		String slotIdentifier = purchasedItem.getSlotIdentifier();
		String logCurrentMoneyAfterPurchase = Purchase.getCurrentMoney().subtract(purchasedItem.getPrice()).toString();
		String purchaseLog = dateFormat.format(currentDateAndTime) + " " + purchasedItemName + " " + slotIdentifier
				+ " $" + logCurrentMoney + " $" + logCurrentMoneyAfterPurchase + "\n";
		writer.append(purchaseLog);
		writer.flush();
		writer.close();
		
	}

	public static void logEndOfTransaction() throws IOException {
		openLog();
		currentDateAndTime = new Date();
		String logMessage = " GIVE CHANGE: ";
		String logCurrentMoney = Purchase.getCurrentMoney().toString();
		Purchase.resetCurrentMoney();
		String logCurrentMoneyAfterChange = Purchase.getCurrentMoney().toString();
		String endOfTransactionLog = dateFormat.format(currentDateAndTime) + logMessage + "$" + logCurrentMoney + " $"
				+ logCurrentMoneyAfterChange + "\n";
		writer.append(endOfTransactionLog);
		writer.flush();
		writer.close();
		
		
	}
	
	
	
	public static void closeWriter() {
		writer.flush();
		writer.close();
	}

}

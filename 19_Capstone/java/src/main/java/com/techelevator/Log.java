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

		if (!outputFile.exists()) {
			System.out.println("Creating new file");
			outputFile.createNewFile();

		}
		writer = new PrintWriter(new FileOutputStream(outputFile, true));
	}

	public static String logFeedMoney(BigDecimal amountFed) throws IOException {
		openLog();
		currentDateAndTime = new Date();
		String logMessage = " FEED MONEY: ";
		String logFedAmount = amountFed.toString();
		String logCurrentMoney = Purchase.getCurrentMoney().toString();
		String feedMoneyLog = logMessage + "$" + logFedAmount + " $" + logCurrentMoney + "\n";
		String feedMoneyLogWithDate = dateFormat.format(currentDateAndTime) + feedMoneyLog;
		writer.append(feedMoneyLogWithDate);
		writer.flush();
		writer.close();
		return feedMoneyLog;

	}

	public static String logPurchase(VendingMachineItem purchasedItem) throws IOException {
		openLog();
		currentDateAndTime = new Date();
		String purchasedItemName = purchasedItem.getName();
		String logCurrentMoney = Purchase.getCurrentMoney().toString();
		String slotIdentifier = purchasedItem.getSlotIdentifier();
		String logCurrentMoneyAfterPurchase = Purchase.getCurrentMoney().subtract(purchasedItem.getPrice()).toString();
		String purchaseLog = " " + purchasedItemName + " " + slotIdentifier
				+ " $" + logCurrentMoney + " $" + logCurrentMoneyAfterPurchase + "\n";
		String purchaseLogWithDate = dateFormat.format(currentDateAndTime) + purchaseLog; 
		writer.append(purchaseLogWithDate);
		writer.flush();
		writer.close();
		return purchaseLog;

	}

	public static String logEndOfTransaction() throws IOException {
		openLog();
		currentDateAndTime = new Date();
		String logMessage = " GIVE CHANGE: ";
		String logCurrentMoney = Purchase.getCurrentMoney().toString();
		Purchase.resetCurrentMoney();
		String logCurrentMoneyAfterChange = Purchase.getCurrentMoney().toString();
		String endOfTransactionLog = logMessage + "$" + logCurrentMoney + " $"
				+ logCurrentMoneyAfterChange + "\n";
		String endOfTransactionLogWithDate = dateFormat.format(currentDateAndTime) + endOfTransactionLog;
		writer.append(endOfTransactionLogWithDate);
		writer.flush();
		writer.close();
		return endOfTransactionLog;

	}

	public static void closeWriter() {
		writer.flush();
		writer.close();
	}

}

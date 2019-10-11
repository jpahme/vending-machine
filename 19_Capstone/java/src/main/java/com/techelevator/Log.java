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
	private static Date currentDateAndTime = new Date();
	private static SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a");

	public static void openLog() throws IOException {

		if (!outputFile.exists()) {
			outputFile.createNewFile();

		}
		writer = new PrintWriter(new FileOutputStream(outputFile.getAbsoluteFile()), true);
	}

	public static void logFeedMoney(BigDecimal amountFed) {

		String logMessage = " FEED MONEY: ";
		String logFedAmount = amountFed.toString();
		String logCurrentMoney = Purchase.getCurrentMoney().toString();
		String feedMoneyLog = dateFormat.format(currentDateAndTime) + logMessage + "$" + logFedAmount + " $"
				+ logCurrentMoney + "\n";
		writer.print(feedMoneyLog);
		writer.flush();
	}

	public static void logPurchase(VendingMachineItem purchasedItem) {
		String purchasedItemName = purchasedItem.getName();
		String logCurrentMoney = Purchase.getCurrentMoney().toString();
		String slotIdentifier = purchasedItem.getSlotIdentifier();
		String logCurrentMoneyAfterPurchase = Purchase.getCurrentMoney().subtract(purchasedItem.getPrice()).toString();
		String purchaseLog = dateFormat.format(currentDateAndTime) + " " + purchasedItemName + " " + slotIdentifier
				+ " $" + logCurrentMoney + " $" + logCurrentMoneyAfterPurchase + "\n";
		writer.print(purchaseLog);
		writer.flush();
	}

	public static void logEndOfTransaction() {

		String logMessage = " GIVE CHANGE: ";
		String logCurrentMoney = Purchase.getCurrentMoney().toString();
		Purchase.resetCurrentMoney();
		String logCurrentMoneyAfterChange = Purchase.getCurrentMoney().toString();
		String endOfTransactionLog = dateFormat.format(currentDateAndTime) + logMessage + "$" + logCurrentMoney + " $"
				+ logCurrentMoneyAfterChange + "\n";
		writer.print(endOfTransactionLog);
		writer.flush();
		writer.close();
	}

}

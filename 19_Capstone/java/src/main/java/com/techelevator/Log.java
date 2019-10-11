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

//	Live Demo
//	import java.util.*;
//	import java.text.*;
//
//	public class DateDemo {
//
//	   public static void main(String args[]) {
//	      Date dNow = new Date( );
//	      SimpleDateFormat ft = 
//	      new SimpleDateFormat ("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
//
//	      System.out.println("Current Date: " + ft.format(dNow));
//	   }
//	}
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
		String feedMoneyLog = dateFormat.format(currentDateAndTime) + logMessage + "$" + logFedAmount + " $" + logCurrentMoney;
		writer.print(feedMoneyLog);
		writer.flush();
	}
	
}

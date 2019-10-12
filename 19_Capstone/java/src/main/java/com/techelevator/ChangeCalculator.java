package com.techelevator;
import java.math.BigDecimal;

public class ChangeCalculator {

	public static String calculateChange(BigDecimal cashTendered) {
		
		int numberOfQuarters = 0;
		int numberOfDimes = 0;
		int numberOfNickels = 0;
		int numberOfPennies = 0;
		BigDecimal quarterValue = new BigDecimal(0.25);
		BigDecimal dimeValue = new BigDecimal(0.10);
		BigDecimal nickelValue = new BigDecimal(0.05);
		BigDecimal pennyValue = new BigDecimal(0.01);
		
		if (cashTendered.compareTo(BigDecimal.ZERO) == -1) {
			return "Invalid";
		}
		while (greaterThanOrEqualToZero(quarterValue, cashTendered)) {
			cashTendered = cashTendered.subtract(quarterValue);
			numberOfQuarters++;
		}
		
		while (greaterThanOrEqualToZero(dimeValue, cashTendered)) {
			cashTendered = cashTendered.subtract(dimeValue);
			numberOfDimes++;
		}
		
		while (greaterThanOrEqualToZero(nickelValue, cashTendered)) {
			cashTendered = cashTendered.subtract(nickelValue);
			numberOfNickels++;
		}
		
		while (cashTendered.doubleValue() > 0) {
			cashTendered = cashTendered.subtract(pennyValue);
			numberOfPennies++;
		}
		
		String totalChange = "Total Change: " + numberOfQuarters + " quarters, " + numberOfDimes + " dimes, " + numberOfNickels + " nickels, and " + numberOfPennies + " pennies";
		System.out.println(totalChange);
		return totalChange;
		 
	}
	
	
	public static boolean greaterThanOrEqualToZero(BigDecimal coinValue, BigDecimal cashTendered) {
		
		if (cashTendered.subtract(coinValue).compareTo(BigDecimal.ZERO) == 1 || cashTendered.subtract(coinValue).compareTo(BigDecimal.ZERO) == 0 ){
			return true;
		}
		return false;
	}
}

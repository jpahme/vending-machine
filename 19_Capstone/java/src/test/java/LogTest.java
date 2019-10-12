import static org.junit.Assert.*;

import java.io.IOException;
import java.math.BigDecimal;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.techelevator.Chips;
import com.techelevator.Log;
import com.techelevator.Purchase;
import com.techelevator.VendingMachineItem;

public class LogTest {

	@Before
	public void setUp() throws Exception {
		Purchase.resetCurrentMoney();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void logFeedMoneyReturnsCorrectLog() throws IOException {
	Purchase.addToCurrentMoney(BigDecimal.valueOf(1).setScale(2));
	String actual = Log.logFeedMoney(BigDecimal.valueOf(1).setScale(2));
	String expected = " FEED MONEY: $1.00 $1.00\n";
	assertEquals(expected, actual);
	}
	
	@Test
	public void logPurchaseReturnsCorrectLog() throws IOException {
	VendingMachineItem potatoCrisps = new Chips("Potato Crisps", BigDecimal.valueOf(3.05).setScale(2), "A1");
	Purchase.addToCurrentMoney(BigDecimal.valueOf(5).setScale(2));
	String actual = Log.logPurchase(potatoCrisps);
	String expected = " Potato Crisps A1 $5.00 $1.95\n";
	System.out.println(actual);
	assertEquals(expected, actual);
	}
	
	@Test
	public void logEndOfTransactionReturnsCorrectLog() throws IOException {
	VendingMachineItem potatoCrisps = new Chips("Potato Crisps", BigDecimal.valueOf(3.05).setScale(2), "A1");
	Purchase.addToCurrentMoney(BigDecimal.valueOf(5).setScale(2));
	String actual = Log.logEndOfTransaction();
	String expected = " GIVE CHANGE: $5.00 $0.00\n";
	System.out.println(actual);
	assertEquals(expected, actual);
	}
	
	

}

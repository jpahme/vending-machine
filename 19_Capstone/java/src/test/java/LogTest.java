import static org.junit.Assert.*;

import java.io.IOException;
import java.math.BigDecimal;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.techelevator.Log;
import com.techelevator.Purchase;

public class LogTest {

	@Before
	public void setUp() throws Exception {
		
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
	Purchase.addToCurrentMoney(BigDecimal.valueOf(1).setScale(2));
	String actual = Log.logFeedMoney(BigDecimal.valueOf(1).setScale(2));
	String expected = " FEED MONEY: $1.00 $1.00\n";
	assertEquals(expected, actual);
	}

}

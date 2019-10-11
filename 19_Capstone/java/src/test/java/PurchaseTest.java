import static org.junit.Assert.*;

import java.io.IOException;
import java.math.BigDecimal;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.techelevator.Purchase;
import com.techelevator.view.Menu;

public class PurchaseTest {

	Purchase purchase = new Purchase();
	Menu menu = new Menu(System.in, System.out);
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetCurrentMoney() {
		BigDecimal expectedResult = BigDecimal.valueOf(0.0).setScale(2);
		BigDecimal actualResult = Purchase.getCurrentMoney();
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void testAddToCurrentMoney() {
		BigDecimal expectedResult = BigDecimal.valueOf(5.0).setScale(2);
		Purchase.addToCurrentMoney(BigDecimal.valueOf(5).setScale(2));
		BigDecimal actualResult = Purchase.getCurrentMoney();
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void testSubtractFromCurrentMoney() {
		BigDecimal expectedResult = BigDecimal.valueOf(2.0).setScale(2);
		Purchase.subtractFromCurrentMoney(BigDecimal.valueOf(3.0));
		BigDecimal actualResult = Purchase.getCurrentMoney();
		assertEquals(expectedResult, actualResult);
	}
	
//	@Test
//	public void testFeedingOneDollar() throws IOException {
//		BigDecimal expectedResult = BigDecimal.valueOf(3.0).setScale(2);
//		purchase.feedMoney(menu);
//		BigDecimal actualResult = Purchase.getCurrentMoney();
//		assertEquals(expectedResult, actualResult);
//		
//	}
	
	
}

import static org.junit.Assert.*;

import java.io.IOException;
import java.math.BigDecimal;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.techelevator.Chips;
import com.techelevator.Purchase;
import com.techelevator.VendingMachineInventory;
import com.techelevator.VendingMachineItem;
import com.techelevator.view.Menu;

public class PurchaseTest {

	Purchase purchase = new Purchase();
	Menu menu = new Menu(System.in, System.out);
	VendingMachineInventory inventory = new VendingMachineInventory();

	@Before
	public void setUp() throws Exception {
		Purchase.resetCurrentMoney();
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
		Purchase.addToCurrentMoney(BigDecimal.valueOf(5.00));
		BigDecimal expectedResult = BigDecimal.valueOf(2.0).setScale(2);
		Purchase.subtractFromCurrentMoney(BigDecimal.valueOf(3.0));
		BigDecimal actualResult = Purchase.getCurrentMoney();
		assertEquals(expectedResult, actualResult);
	}

	@Test
	public void resetCurrentMoneySetsCurrentMoneyToZero() {
		BigDecimal expectedResult = BigDecimal.valueOf(0).setScale(2);
		Purchase.resetCurrentMoney();
		BigDecimal actualResult = Purchase.getCurrentMoney();
		assertEquals(expectedResult, actualResult);

	}

	@Test
	public void testSubtractOneFromStockReturnsFour() {
		VendingMachineItem chips = new Chips("Lays", BigDecimal.valueOf(1.50).setScale(2), "A1");
		Integer expectedResult = 4;
		purchase.subtractOneFromStock(chips);
		Integer actualResult = chips.getStock();
		assertEquals(expectedResult, actualResult);

	}

	@Test
	public void testSubtractOneFromStockZeroReturnsFour() {
		VendingMachineItem chips = new Chips("Lays", BigDecimal.valueOf(1.50).setScale(2), "A1");
		Integer expectedResult = 0;
		chips.setStock(0);
		purchase.subtractOneFromStock(chips);
		Integer actualResult = chips.getStock();
		assertEquals(expectedResult, actualResult);

	}

	@Test
	public void dispensingItemCreatesCorrectMessage() throws IOException {
		VendingMachineItem chips = new Chips("Lays", BigDecimal.valueOf(1.50).setScale(2), "A1");
		Purchase.addToCurrentMoney(BigDecimal.valueOf(1.50));
		String expectedResult = "Dispensing: Lays $1.50 $0.00";
		String actualResult = purchase.dispense(chips);
		assertEquals(expectedResult, actualResult);
	}

	@Test
	public void whenOneAndFiveIsPassedCurrentMoneyShouldBeSix() {

		Purchase.addToCurrentMoney(BigDecimal.valueOf(1));
		Purchase.addToCurrentMoney(BigDecimal.valueOf(5));
		BigDecimal expectedResult = BigDecimal.valueOf(6).setScale(2);
		BigDecimal actualResult = Purchase.getCurrentMoney();
		assertEquals(expectedResult, actualResult);
	}


}

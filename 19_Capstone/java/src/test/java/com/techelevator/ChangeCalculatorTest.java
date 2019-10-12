package com.techelevator;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ChangeCalculatorTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void insertingFortyOneCentsReturnsOneOfEachCoin() {
		String expectedResult = "Total Change: 1 quarters, 1 dimes, 1 nickels, and 1 pennies";
		String actualResult = ChangeCalculator.calculateChange(BigDecimal.valueOf(0.41));
		assertEquals(expectedResult, actualResult);
		
	}
	
	@Test
	public void insertingZeroReturnsZeroChange() {
		String expectedResult = "Total Change: 0 quarters, 0 dimes, 0 nickels, and 0 pennies";
		String actualResult = ChangeCalculator.calculateChange(BigDecimal.valueOf(0.0));
		assertEquals(expectedResult, actualResult);
				
	}
	
	@Test
	public void enteringNegativeNumberReturnsInvalid() {
		String expectedResult = "Invalid";
		String actualResult = ChangeCalculator.calculateChange(BigDecimal.valueOf(-1));
		assertEquals(expectedResult, actualResult);
	}
	
	
}

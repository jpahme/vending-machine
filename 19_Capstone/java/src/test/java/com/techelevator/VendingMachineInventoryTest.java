package com.techelevator;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class VendingMachineInventoryTest {

	VendingMachineInventory inventory = new VendingMachineInventory();
	
	@Test
	public void createInventoryaddsStackersToInventory() {
		String expectedResult = "Stackers";
		inventory.createInventory();
		String actualResult = inventory.getVendingMachineInventory().get(1).getName();
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void createInventoryaddsCrunchieToInventory() {
		String expectedResult = "Crunchie";
		inventory.createInventory();
		String actualResult = inventory.getVendingMachineInventory().get(7).getName();
		assertEquals(expectedResult, actualResult);
	}

	@Test
	public void createInventoryaddsColaToInventory() {
		String expectedResult = "Cola";
		inventory.createInventory();
		String actualResult = inventory.getVendingMachineInventory().get(8).getName();
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void createInventoryaddsChicletsToInventory() {
		String expectedResult = "Chiclets";
		inventory.createInventory();
		String actualResult = inventory.getVendingMachineInventory().get(14).getName();
		assertEquals(expectedResult, actualResult);
	}
	
	
}

package com.TeqApp.testCases;

import org.testng.annotations.Test;

import com.TeqApp.pageObjects.tripsPageObjects;

public class TC_01_TripsTest extends BaseClass{
	
	tripsPageObjects tp = new tripsPageObjects();

	@Test
	public void tripTest() throws Exception
	{
		System.out.println("Test Started");
		tp.givePermission();
		tp.normalTrip();
		//tp.fixedTrip();
		
		
	}
}

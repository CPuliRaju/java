package com.TestNG;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Annotations4 {

	@BeforeTest
	public void gmailApplicationlounch()
	
	{
		System.out.println("***gmailApplicationLaunch successful***");
	}
	
	@AfterTest
	public void gmailInBoxTest()
	{
		System.out.println("InBox Fuctionality Test Executed  successfully");
	}
	
	@Test(priority=3)
	public void gmailComposemailTest()
	{
		System.out.println("Composemail test Fuctionality Test Executed  successfully");
	}
	
	@Test(priority=5)
	public void gmailSentMailTest()
	{
		System.out.println("Sentmail test Fuctionality Test Executed  successfully");
	}
	
	@Test(priority=4)
	public void gmailDroftTest()
	{
		System.out.println("Droft test Fuctionality Test Executed  successfully");
	}
	
	@AfterTest
	public void gmailApplicationclose()
	{
		System.out.println("***gmailApplicationclose successful***");
	}
}

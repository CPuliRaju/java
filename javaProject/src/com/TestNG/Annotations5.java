package com.TestNG;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class Annotations5 {

	@BeforeMethod
	public void gmailApplicationlounch()
	
	{
		System.out.println("***gmailApplicationLaunch successful***");
	}
	
	@AfterMethod
	public void gmailInBoxTest()
	{
		System.out.println("InBox Fuctionality Test Executed  successfully");
	}
	
	@Test(priority=1)
	public void gmailComposemailTest()
	{
		System.out.println("Composemail test Fuctionality Test Executed  successfully");
	}
	
	@Test(priority=2)
	public void gmailSentMailTest()
	{
		System.out.println("Sentmail test Fuctionality Test Executed  successfully");
	}
	
	@Test(priority=3)
	public void gmailDroftTest()
	{
		System.out.println("Droft test Fuctionality Test Executed  successfully");
	}
	
	@AfterMethod
	public void gmailApplicationclose()
	{
		System.out.println("***gmailApplicationclose successful***");
	}
}

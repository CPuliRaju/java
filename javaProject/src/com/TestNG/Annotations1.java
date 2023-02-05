package com.TestNG;

import org.testng.annotations.Test;

public class Annotations1 {

	@Test
	public void gmailApplicationlounch()
	
	{
		System.out.println("***gmailApplicationLaunch successful***");
	}
	
	@Test
	public void gmailInBoxTest()
	{
		System.out.println("InBox Fuctionality Test Executed  successfully");
	}
	
	@Test
	public void gmailComposemailTest()
	{
		System.out.println("Composemail test Fuctionality Test Executed  successfully");
	}
	
	@Test
	public void gmailSentMailTest()
	{
		System.out.println("Sentmail test Fuctionality Test Executed  successfully");
	}
	
	@Test
	public void gmailDroftTest()
	{
		System.out.println("Droft test Fuctionality Test Executed  successfully");
	}
	
	@Test
	public void gmailApplicationclose()
	{
		System.out.println("***gmailApplicationclose successful***");
	}
}

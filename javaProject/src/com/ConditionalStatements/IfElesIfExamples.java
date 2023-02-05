package com.ConditionalStatements;

public class IfElesIfExamples {

	public static void main(String[] args) {
		
		 
		int var1=90;
		int var2=80;
		int var3=70;
		if(var1>var2&var1>var3)
			
		{
		System.out.println("var1>var2&var3");
		
		}
		else
		{
		if(var2>var3)			
		{
		System.out.println("var2.var1&var3");
		}
		else
		{
		System.out.println("var3>var1&var2");
		}
		}

	}

}

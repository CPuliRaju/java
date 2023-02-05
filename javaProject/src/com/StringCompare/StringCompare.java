package com.StringCompare;

public class StringCompare {

	public static void main(String[] args) {

		String String1="Live Tech";
		System.out.println("string1");
		
		System.out.println("string1.charAt(2)");
		
		char charAtIndex=String1.charAt(4);
		System.out.println("The valueof the variablecharAtIndexis:"+charAtIndex);
		
		int charAtNewIndex=String1.charAt(4);
		System.out.println("charAtNewIndex");
		
		String String2="Live Tech";
		String String3="Live tech";
		
		if (String2.equals(String3))
		{
		System.out.println("variable string2 and variable string3 are equal");
		}
		else
		{
		System.out.println("variable string2 and variable string3 are equal");
		}
		String String4="Testing Tools";
		String String5="Testing tools";
		if(String4.equalsIgnoreCase(String5))
		{
		System.out.println("variable string4 and variable string5 are equal");
		}
		
		String String6="LoadRunner";
		
		String ConvertedStringtoUpperCase=String6.toUpperCase();
		System.out.println("The string value string6 Convrted to UpperCase:"+ConvertedStringtoUpperCase);
		
		String ConvertedStringtoLowerCase=String6.toLowerCase(); 
		System.out.println("The string value string6 Convrted to lowerCase:"+ConvertedStringtoLowerCase);
		
		String String7="Live Tech";
		String String8="Tech";
		
		if(String7.contains(String8))
		{
		System.out.println("Expected string is found - string7 contains string8");
		}
		else
		{
		System.out.println("Expected string is not found - string7 nocontains string8");
		}
		
	}

}

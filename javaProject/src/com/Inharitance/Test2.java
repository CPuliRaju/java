package com.Inharitance;

public class Test2 extends Test1{

	public void subtraction()
	{
		int var1=20;
		int var2=10;
		int var3;
		
		var3=var1+var2;
		System.out.println("The value of var3 after subtraction is :-"+var3);
	}
	public void multiplication()
	{
		int var1=20;
		int var2=10;
		int var3;
		
		var3=var1+var2;
		System.out.println("The value of var3 after multiplication is :-"+var3);	
	}
	public static void main(String[] args) {
		Test2 t2=new Test2();
		t2.subtraction();
		t2.multiplication();
		System.out.println();
		System.out.println("*******Test1 class methods**********");
		
		t2.addition();
		
	}
}

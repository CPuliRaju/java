package com.Methods;

public class MethodExample4 {

	public void multiplication()
	{
		int var1 =20;
		int var2 =10;
		int var3;
		
		var3=var1*var2;
		System.out.println("The value of var3 after multiplication is :-"+var3);
	}
	public static void main(String[] args) {
		
		MethodExample4 m4=new MethodExample4();
		m4.multiplication();
		//Calling the method of other class into the current class by creating an object for that class in which 
		//used defined methods are created
		MethodExample3 obj = new MethodExample3();
		obj.addition();
		m4.subtraction();
		m4.subtraction();
		m4.subtraction(40, 20);
	}
	public void subtraction()
	{
		int var1 =20;
		int var2 =10;
		int var3;
		
		var3=var1-var2;
		System.out.println("The value of var3 after subtraction is :-"+var3);
	}
	public void subtraction(int var1,int var2)
	{
		int var3;
		
		var3=var1-var2;
		System.out.println("The value of the variable var3 with parametors of the subtraction is :-"+var3);
	}
}

package com.Methods;

public class MethodExample3 {

	public void addition()
	{
		//Local variable
		int var1=10;
		 var1=50;
		 int var2=20;
		 int var3;
		 
		 var3=var1+var2;
		 System.out.println("The value of the variable var3 after addition is :-"+var3);
	}
	
	public static void main(String[] args) {
		MethodExample3 obj = new MethodExample3();
	    obj.addition();
	    obj.subtraction();
	}
	private void subtraction()
	{
	int var1=10;
	int var2=20;
	int var3;
	
	var3=var1-var2;
	System.out.println("The value of the variable var3 after subtraction is :-"+var3);
	}
}

package com.Methods;

public class Method_Example2 {


		
		//Global Variable
		int var1=30;
		int var2=20;
		
		//Variable declared outside the methods are global variables
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
		
			Method_Example2 m2=new Method_Example2();
			
			m2.addition();
			m2.subtraction();
			m2.multiplication();
			m2.division();
		}
		private void subtraction()
		{
		int var1=10;
		int var2=20;
		int var3;
		
		var3=var1-var2;
		System.out.println("The value of the variable var3 after subtraction is :-"+var3);
		}
		
		protected void multiplication()
		{
			int var3;
			
			var3=var1*var2;
			System.out.println("The value of the variable var3 after multiplication is :-"+var3);
		}
		
		void division()
		{
			int var1=100;
			int var2=20;
			int var3;
			
			var3=var1/var2;
			System.out.println("The value of the variable var3 after division is :-"+var3);
		}
		
	}



package cpm.Loops;

public class NestedLoopExample {

	public static void main(String[] args) {
		
		//A ForLoop which contain inside another FoorLoop is called Nasted ForLoop.
		for(int a=1;a<=4;a++)
		{
		   for(int b=0;b<a;b++)
		{
		System.out.println("Testing");
		}
		   
		}
		
		for(int a1=1;a1<=4;a1++)
		{
		for(int b=0;b<a1;b++)
		{
	     	System.out.print(a1+"");
		}
		    System.out.println();
		}
			
		System.out.println("=============");
		
		
		for(int a1=1;a1<=4;a1++)
		{
		for(int b=1;b<=a1;b++)
		{
		  System.out.print(b+"");
		}
		    System.out.println();
		}
		System.out.println("%%%%%%%%%%%%%");
		
		
		System.out.println("1");
		for(int a1=3;a1<=4;a1++)
		{
		for(int b=1;b<=a1;b++)
		{
		   System.out.print(b+"");
		}
		     System.out.println(); 
		}
		System.out.println("&&&&&&&&&&&");
		
		
		for(int a1=7;a1>=5;a1--)
		{
		for(int b=a1;b>=5;b--)
		{
	    	System.out.print(b+"");
		}
		     System.out.println(); 
		}
		 


	}

}

package cpm.Loops;

public class DoWhileExample {

	public static void main(String[] args) {
		
		
		//Do_WhileLoop is a Post-Test Loop.It is used when we want to Execute Loop body At least once even condition is false
		//It is known as Exit ControlLoop
		//When condition false do while loop execute or at least print one time in any situvation
		int var=3;
		
		do 
		{
		System.out.println("LiveTech");
		var++;
		}
		while(var>=5);
		System.out.println("@@@@@@@@@@@@@");
		int var1=-8;
		do
		{
		System.out.println(var1+""+"Selenium");
		var++;
		}while(var1<=-3);
		System.out.println("$$$$$$$$$$$$$$$$$");
		int a=-45;
		do
		{
		System.out.println("LoadRunner");
		var--;
		}while(a>=49);
		 
	
	}

}

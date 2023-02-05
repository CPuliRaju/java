package com.WebTable;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DynamicWebTable extends BaseTest{

	public void capturingDynamicWebTableData1()
	{
		
		//Identifying the webPage
		///html/body/div[5]/section[1]/div/section/div[1]/div/table
		By webTableLocator=By.xpath("/html/body/div[5]/section[1]/div/section/div[1]/div/table");
		WebElement WebTable=driver.findElement(webTableLocator);
		
	//In the Table - identifying the number of rows
		By tablerowLocator=By.tagName("tr");
		List<WebElement>tablerows=WebTable.findElements(tablerowLocator);
		System.out.println(tablerows.size());
        
		
		//To goto all the row 
		for (int rowindex=0;rowindex<tablerows.size();rowindex++)
		{
			By rowofcellsLocator=By.tagName("td");
			
			//goes to a row and identifying number of cells
			List<WebElement>tablerowofcells=tablerows.get(rowindex).findElements(rowofcellsLocator);
			System.out.println(rowindex+" "+tablerowofcells.size());
			
			
			//goes every row of all the cells
			for(int rowofcellindex=0;rowofcellindex<tablerowofcells.size();rowofcellindex++)
			{
				//goto every row of a cell - get the data
				String tabledata=tablerowofcells.get(rowofcellindex).getText();
				System.out.print(tabledata+" ");
			}
			System.out.println();
		
		}
	}
	public static void main(String[] args) {
		DynamicWebTable dynamicwebtable=new DynamicWebTable();
		dynamicwebtable.Applicationlaunch();
		dynamicwebtable.capturingDynamicWebTableData1();
		dynamicwebtable.Applicationclose();
	}
}

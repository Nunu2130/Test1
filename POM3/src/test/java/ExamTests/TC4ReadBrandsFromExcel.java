package ExamTests;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import frameWorkClasses.BasePage;
import frameWorkClasses.ReadExcel;

public class TC4ReadBrandsFromExcel {
	
	 
	ReadExcel rExcel = new ReadExcel(); 
	BasePage bp =  new BasePage();	
	//Data providers
	
	@Test(dataProvider = "productData")
	public void readProductFile(String Brand , String Quantity)
		{
		//System.out.println("Takealot Product List");
		System.out.println(Brand + " "+Quantity);
	//	System.out.println(" ");
		}
	
	
	@DataProvider(name = "productData")
	public Object[][] getDataFromExcel() throws IOException
	{
	 
	String excelDirectory = rExcel.getDataConfigProperties ("excelDataDir");
	Object[][] arrObj = rExcel.getExcelData(excelDirectory+"TakealotProductList.xlsx","Sheet1");
	
	return arrObj;
	
	}
	
	
	
	/*@Test
	public void GIVEN_ICLickDailyDeals_THEN_AssertNumberOfItems() throws InterruptedException
	
	//7 click the go to Cart button
	//8 select 2 as the quantity 
	//9 Assert that the cart value is displayed correctly



	{
			
		//GIVEN
		//I Click Daily Deals
		ex.clickGotIt();	
		ex.clickDailyDeals();
		Thread.sleep(1000);
			 
		//WHEN
		//I Select a brand 
		ex.captureBrand("Western Digital");
		ex.clickBrand();
		 
		//THEN 	
		//I Assert Item count  
		ex.ScrollUp();
		ex.confirmItemCount();
		String itemCount = ex.confirmItemCount();
		System.out.println(""+itemCount);
		
		String expectedItemCount = ex.confirmZeroCount();
		Thread.sleep(1000);
		Assert.assertEquals(itemCount, expectedItemCount);
		System.out.println("The Items found = " +itemCount+" : Items greater than Zero");
		ex.cleanup();*/
	
	}
	
	


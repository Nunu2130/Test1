package ExamTests;

 

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Exam.ExamObj;
import frameWorkClasses.BasePage;
import frameWorkClasses.ReadExcel;

public class TC4ReadBrandsFromExcel {

	ExamObj ex = new ExamObj(); 
	BasePage bp =  new BasePage(); 
	ReadExcel rExcel = new ReadExcel(); 
	//public static WebDriver driver;
	
	@BeforeTest
	public void cookies() 
	{
		ex.clickGotIt();
	}	
	
	
	@Test(dataProvider = "TakealotProductList")
	public void GIVEN_ICLickFistItemInDailyDeals_AND_IADDtoCart_THEN_IAssertItemAddedToCart(String Brand,String Quantity) throws InterruptedException
	
		//4 Click the first item 
		//5 Add it to the cart
		//6 Assert that “Added to cart” appears at the top of the pop up window
	{
		
			
		//GIVEN
			//I Click Daily Deals and select first Item
			//ex.clickGotIt();
			Thread.sleep(1000);	
			ex.captureMainBrand(Brand);	
			Thread.sleep(1000);
			ex.clickSearchIcon();
			Thread.sleep(1000);
				 
		//WHEN
			//I add to Cart
			ex.clickFirstItem();
			Thread.sleep(2000);
			Thread.sleep(1000);
			ex.clickAddItemToCart();
			Thread.sleep(1000);
			ex.clickSlider();
//			ex.CartConfirmMsg();
//						
//		//THEN
//			//I Assert that Item is added to cart   
//		 	String successMsg = ex.CartConfirmMsg();
//			String expectedsuccessMsg = ("Added to cart");
//			System.out.println("");
//			Assert.assertEquals(successMsg, expectedsuccessMsg);
//			System.out.println("Selected item has been Added to Cart");
//			System.out.println("");
//			
			//ex.close();
			//bp.cleanup();
		
	}
	
	@DataProvider(name = "TakealotProductList")
	public Object[][] getDataFromExcel() throws IOException
	{
	 
	Object[][] arrObj = rExcel.getExcelData("C:\\Temp\\TakealotProductList.xlsx","Sheet1");
	return arrObj;
		
	}
	  
}


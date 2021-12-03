package ExamTests;

import java.io.IOException;
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
	
	@BeforeTest
	public void cookies() 
		{
			ex.clickGotIt();
		}	
		
	
	@Test(dataProvider = "TakealotProductList")
	public void GIVEN_ICLickFistItemInDailyDeals_AND_IADDtoCart_THEN_IAssertItemAddedToCart(String Brand,String Quantity) throws InterruptedException
		//
	{
		//GIVEN
			//I Click Daily Deals and select first Item
		 
			ex.captureMainBrand(Brand);	
			Thread.sleep(1000);
			ex.clickSearchIcon();
			Thread.sleep(1000);
				 
		//WHEN
			//I add to Cart
			ex.clickFirstItem();
			Thread.sleep(2000);
			ex.SwitchToNewTab();
			ex.clickAddItemToCart();
			Thread.sleep(1000);
			ex.clickGoToCart();
			Thread.sleep(1000);
			ex.ExcelCartValue(Quantity);
			Thread.sleep(1000);		
			//ex.clear();				
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

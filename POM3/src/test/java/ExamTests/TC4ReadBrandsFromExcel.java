package ExamTests;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import examObj.ExamObj;
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
			//I add each brand to Cart
			ex.ConfirmPricing();
			Thread.sleep(1000);
			ex.clickFirstItem();
			Thread.sleep(1000);
			ex.SwitchToNewTab();
			Thread.sleep(1000);
			ex.clickAddItemToCart();
			Thread.sleep(1000);
			ex.clickGoToCart();
			Thread.sleep(1000);
			ex.ExcelCartValue(Quantity);
			Thread.sleep(1000);
						
		//THEN
			//I Assert cart  summary
			
			String unitPrice = ex.ConfirmPricing();
			int i = Integer.parseInt(unitPrice.replaceAll(",", "").substring(2));
			
			String Qua = Quantity;
			int j = Integer.parseInt(Qua);
			int CTotal = i * j;
			
			System.out.println("");
			System.out.println(" YOUR CART ITEMS ");
			System.out.println("");
			System.out.println(Quantity+" X "+Brand+" @ "+unitPrice+" Per Item      Total = "+CTotal);
			System.out.println("");
			
			String Totprice = ex.CartSummaryPricing();
			int h = Integer.parseInt(Totprice.replaceAll(",", "").substring(2));
			int TotTot = h*j;
			Assert.assertEquals(TotTot,CTotal);
				
	}
	
		@DataProvider(name = "TakealotProductList")
		public Object[][] getDataFromExcel() throws IOException
		{
		 
		Object[][] arrObj = rExcel.getExcelData("C:\\Temp\\TakealotProductList.xlsx","Sheet1");
		return arrObj;
			
		}
	
		@AfterTest
		public void cleanup() 
			{
				bp.cleanup();
			}	
		    
}

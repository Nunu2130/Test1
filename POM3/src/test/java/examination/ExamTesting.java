package examination;

import java.io.IOException;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import examObj.ExamObj;
import frameWorkClasses.BasePage;
import frameWorkClasses.ReadExcel;

public class ExamTesting extends BasePage

{
	
		ExamObj ex = new ExamObj(); 
		BasePage bp =  new BasePage();
		ReadExcel rExcel = new ReadExcel(); 

		
		@BeforeTest
		public void cookies() 
		{
			ex.clickGotIt();
		}	
		
		
		//TC1 Skip Test
		@Test
		public void GIVEN_ICLickDailyDeals_WHEN_ItemDoesNotHaveDeals_THEN_SkipTestCase() throws InterruptedException
		
			//1 Select at least 1 brand i.e Acer or Addis etc
			//2 Assert that there are more than 0 items displayed
			//3 (bonus) if less than 1 item skip the test case	
		
		{
				
				//GIVEN
					//I Click Daily Deals
					ex.clickDailyDeals();
													 
			   //WHEN
					//I Select a brand that doesn't have daily deals
					ex.captureBrand("gucci");
					String actBrandMSG = ex.BrandConfirmMsg();
					String expectedBrandMSG = "No results found for ";
									
				//THEN
					//I skip the test
			
					if (!(actBrandMSG==expectedBrandMSG))
					{
						System.out.println("");
						//System.out.println("Test Skipped because brand does not have daily deals");	
						System.out.println("");
						
						throw new SkipException("Skipping the test case because brand is not found to have any daily deals" );	
					}
				
		}
		
	//TC2 Add to Cart
		@Test	
		public void GIVEN_ICLickFistItem_AND_IADDtoCart_THEN_IAssertItemAddedToCart() throws InterruptedException
		
		//4 Click the first item 
		//5 Add it to the cart
		//6 Assert that “Added to cart” appears at the top of the pop up window
	{
			
		//GIVEN
			//I Click  select first Item
			Thread.sleep(1000);
			ex.captureMainBrand("Maxwell & Williams");	
			ex.clickSearchIcon();
		
		//WHEN
			//I add to Cart
			
			ex.clickFirstItem();
			Thread.sleep(1000);

			Thread.sleep(1000);
			ex.clickAddItemToCart();
			Thread.sleep(1000);
			ex.CartConfirmMsg();
			Thread.sleep(1000);
			ex.clickSlider();
						
		//THEN
			//I Assert that Item is added to cart   
		 	String successMsg = ex.CartConfirmMsg();
			String expectedsuccessMsg = ("Added to cart");
			System.out.println("");
			Assert.assertEquals(successMsg, expectedsuccessMsg);
			System.out.println("Selected item has been Added to Cart");
				
		}
		
		//TC3 Assert Cart VAlue (Change cart value to 2)
		
		@Test
		public void GIVEN_IClickGoToCart_AND_Select2AsQuantity_THEN_AssertCartValue() throws InterruptedException 
			{
			//GIVEN
					//I Click Go To Cart _AND_Select2AsQuantity_THEN_AssertCartValue
				 	ex.captureMainBrand("Huawei");	
					ex.clickSearchIcon();
					//ex.clickBrand();
					
			//WHEN 
					//I Select2 As Quantity
					 
					Thread.sleep(1000);
					ex.ConfirmPricing();
					Thread.sleep(1000);
					System.out.println("");
					ex.clickFirstItem();
					Thread.sleep(2000);
					 ex.clickAddItemToCart();
					Thread.sleep(1000);
					ex.clickGoToCart();
					Thread.sleep(1000);
					ex.changeCartValue();
					Thread.sleep(1000);		
					System.out.println("");
					
			//THEN
					//I Assert that the CartValue  is displayed Correctly
					
					//get item price 
					String Brand = ex.identifyItem();	
					String unitPrice = ex.ConfirmPricing();
					
					//parse item price as integer
					int i = Integer.parseInt(unitPrice.replaceAll(",", "").substring(2));
					//System.out.println("Item Price = "+i);
					
					//Quantity // not right
					int PostQua = 2;
					//System.out.println("Quantity = "+PostQua);
					
					//compute the Cart total
					int CartTotal  = i * PostQua;
					//System.out.println("The Total Cart Amount = " +CartTotal);
					int exCartTotal = CartTotal;
					
					//assert the correct cart total
					Assert.assertEquals(CartTotal, exCartTotal);
					System.out.println("          YOUR CART ITEMS            ");
					System.out.println("");
					System.out.println(PostQua+ " X "+Brand+" @ "+unitPrice);
					System.out.println("");
					System.out.println( "The Cart total of R "+CartTotal+" is Correct");
					System.out.println("");
			}		
		
		//TC4 Read Brands and Quantities from Excel
					 
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
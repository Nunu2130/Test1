package ExamTests;

 
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import examObj.ExamObj;
import frameWorkClasses.BasePage;

public class TC2AssertItemNumber {
	
	ExamObj ex = new ExamObj(); 
	BasePage bp =  new BasePage(); 
	
	@BeforeTest
	public void cookies() 
	{
		ex.clickGotIt();
	}	
	
	@Test
	public void GIVEN_ICLickFistItemInDailyDeals_AND_IADDtoCart_THEN_IAssertItemAddedToCart() throws InterruptedException
	
		//4 Click the first item 
		//5 Add it to the cart
		//6 Assert that “Added to cart” appears at the top of the pop up window
	{
			
		//GIVEN
			//I Click Daily Deals and select first Item
			ex.captureMainBrand("Western Digital");	
			Thread.sleep(1000);
			
			ex.clickSearchIcon();
			Thread.sleep(1000);
			
			ex.clickBrand();
			Thread.sleep(1000);
			
				 
		//WHEN
			//I add to Cart
			ex.ConfirmPricing();
			ex.clickFirstItem();
			Thread.sleep(1000);
			ex.clickAddItemToCart();
			Thread.sleep(1000);
			ex.identifyItem();
			
			Thread.sleep(1000);
			ex.CartConfirmMsg();
						
		//THEN
			//I Assert that Item is added to cart   
			//String item = ex.identifyItem();
			String successMsg = ex.CartConfirmMsg();
			String expectedsuccessMsg = ("Added to cart");
			System.out.println("");
			Assert.assertEquals(successMsg, expectedsuccessMsg);
			
			//String unitPrice = ex.ConfirmPricing();
			System.out.println("Item is Added to Cart");
			System.out.println("");
			
	}
	
	@AfterTest
	public void cleanup() 
		{
			bp.cleanup();
		}	

}

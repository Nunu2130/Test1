package ExamTests;

 import org.testng.Assert;

import frameWorkClasses.BasePage;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import examObj.ExamObj;
public class TC1AddToCart
{
	
	ExamObj ex = new ExamObj(); 
	BasePage bp =  new BasePage();
	
	@BeforeTest
	public void cookies() 
	{
		ex.clickGotIt();
	}	
	
	
	@Test	
	public void GIVEN_ICLickFistItem_AND_IADDtoCart_THEN_IAssertItemAddedToCart() throws InterruptedException
	
	//4 Click the first item 
	//5 Add it to the cart
	//6 Assert that “Added to cart” appears at the top of the pop up window
{
		
	//GIVEN
		//I select first Item
		ex.captureMainBrand("Maxwell & Williams");	
		Thread.sleep(1000);
		ex.clickSearchIcon();
		Thread.sleep(1000);
			 
	//WHEN
		//I add to Cart
		ex.clickFirstItem();
		Thread.sleep(1000);
		ex.clickAddItemToCart();
		Thread.sleep(1000);
		ex.CartConfirmMsg();
		ex.clickSlider();
					
	//THEN
		//I Assert that Item is added to cart  
		String successMsg = ex.CartConfirmMsg();
		String expectedsuccessMsg = ("Added to cart");
		System.out.println("");
		Assert.assertEquals(successMsg, expectedsuccessMsg);
		//String item = ex.identifyItem();
		//System.out.println(item);
		System.out.println("Selected item has been Added to Cart");
		System.out.println("");
	}	
	
	@AfterTest
	public void cleanup() 
		{
			bp.cleanup();
		}	
}
	
	


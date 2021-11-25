package ExamTests;

import org.openqa.selenium.support.ui.Select;
//import org.testng.Assert;
import org.testng.annotations.Test;

import Exam.ExamObj;
import frameWorkClasses.BasePage;

public class TC3AssertCartValue
{
	
	
	
	ExamObj ex = new ExamObj(); 
	BasePage bp =  new BasePage();
	
	@Test
	public void GIVEN_IClickGoToCart_AND_Select2AsQuantity_THEN_AssertCartValue() throws InterruptedException
	
	//7 click the go to Cart button
	//8 select 2 as the quantity 
	//9 Assert that the cart value is displayed correctly
	{
		
	//GIVEN
		//I Click Go To Cart _AND_Select2AsQuantity_THEN_AssertCartValue
		ex.clickGotIt();
		Thread.sleep(1000);	
		ex.captureMainBrand("Western Digital");	
		Thread.sleep(1000);
		ex.clickSearchIcon();
		Thread.sleep(1000);
			 
	//WHEN
		//I select 2 As Quantity
		ex.clickFirstItem();
		Thread.sleep(2000);
		Thread.sleep(1000);
		ex.clickAddItemToCart();
		Thread.sleep(2000);
		ex.clickGoToCart();
	
			
						
	//THEN
		//I Assert that the CartValue  is displayed Correctly
		//ex.selectCartValue();
		Thread.sleep(1000);
		ex.ConfirmPricing();
		Thread.sleep(1000);
		System.out.println("");
		System.out.println("Price per item = "+ex.ConfirmPricing());
		
		String unitPrice = ex.ConfirmPricing();
		Integer.parseInt(unitPrice);
		System.out.println(unitPrice);
		
	
		Thread.sleep(1000);
		ex.changeCartValue();
		Thread.sleep(1000);		
		
		Select Quantity = ex.changeCartValue();
		//Integer.parseInt(Quantity);
		System.out.println("Selected Quantity = "+ex.changeCartValue());
		
			
		System.out.println("");
		System.out.println("I changed value  to 2");
		
		System.out.println("");

	
		
		
		
		//String expectedInCartValue = "2";
		//Assert.assertEquals(InCartValue, expectedInCartValue);
		
		bp.cleanup();
	}

}
	

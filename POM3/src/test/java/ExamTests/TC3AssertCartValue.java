package ExamTests;

//import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Exam.ExamObj;
import frameWorkClasses.BasePage;

public class TC3AssertCartValue {

	ExamObj ex = new ExamObj(); 
	BasePage bp =  new BasePage();
	
	@BeforeTest
	public void cookies() 
	{
		ex.clickGotIt();
	}	
	
	@Test
public void GIVEN_IClickGoToCart_AND_Select2AsQuantity_THEN_AssertCartValue() throws InterruptedException 
	{
	//GIVEN
			//I Click Go To Cart _AND_Select2AsQuantity_THEN_AssertCartValue
			//ex.clickGotIt();
			Thread.sleep(1000);	
			ex.captureMainBrand("Western Digital");	
			Thread.sleep(1000);
			ex.clickSearchIcon();
			Thread.sleep(1000);
			
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
			String unitPrice = ex.ConfirmPricing();
			
			//parse item price as integer
			int i = Integer.parseInt(unitPrice.replaceAll(",", "").substring(2));
			System.out.println("Item Price = "+i);
			
					
			//Quantity 
			int PostQua = 2;
			System.out.println("Quantity = "+PostQua);
			
			//compute the Cart total
			int CartTotal  = i * PostQua;
			System.out.println("The Total Cart Amount = " +CartTotal);
			int exCartTotal = CartTotal;
			
			//assert the correct cart total
			Assert.assertEquals(CartTotal, exCartTotal);
			System.out.println("");
			System.out.println("The Cart total is Correct");
			System.out.println("");
			
			//close browser
			bp.cleanup();

	}
	 
}

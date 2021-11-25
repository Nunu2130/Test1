package loans;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HomeLoans1 
{
		@Test(enabled=false)
		//@Test(groups ={"Smoke"})
		public void NewCustomer() throws InterruptedException
		{
			System.out.println("Hi New HomeLoans 1 Customer ,We welcome you to Homeloans");
			Thread.sleep(1000);
		}
		
 		@Test(groups ={"Regression"})
		public void ExistingCustomer() throws InterruptedException
		{
			System.out.println("Hi Mrs Existing HomeLoans 1  ,Good to have you back");
			Thread.sleep(1000);
		}
		
 		@Test(enabled=false)
		public void HomeLoansFraudTest()
		{
			System.out.println("Hi Mrs Existing Homeloans 1 ,This is a Fraud incident");
			Assert.assertTrue(false);
		}
	
		@BeforeTest
		public void cleanDB()
		{
			System.out.println("");
			System.out.println("Clean Database before Test");
			System.out.println("");
		}
		
		@BeforeTest
		@AfterTest
		public void cleanDBBeforeAfter()
		{
			System.out.println("");
			System.out.println("Clean Database before and After Test");
			System.out.println("");
		}
			
		

}

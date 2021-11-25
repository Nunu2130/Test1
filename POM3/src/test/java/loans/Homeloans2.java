package loans;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Homeloans2 
{
	 		 
		@Test(groups ={"Smoke"})
		public void NewCustomer2()
		{
			System.out.println("Hi New Customer HomeLoans 2 ,We welcome you to Homeloans2");
		}
		
		@Test(groups ={"Regression"})
		public void ExistingCustomer2() throws InterruptedException
		{
			System.out.println("Hi Mr Existing HomeLoans 2,Good to have you back");
			Thread.sleep(1000);
		}
	
		@Test(enabled =true)
		public void HomeLoans2FraudTest() throws InterruptedException
		{
				System.out.println("Hi Mrs Existing Homeloans 2 ,This is a Fraud incident");
				Thread.sleep(1000);
		}
		@BeforeTest
		
		public void cleanDB()
		{
			System.out.println("");
			System.out.println("Clean Database before Test");
			System.out.println("");
		}
		
		//@BeforeTest
		@AfterTest
		public void cleanDBBeforeAfter()
		{
			System.out.println("");
			System.out.println("Clean Database After Test");
			System.out.println("");
		}
		@BeforeSuite
		public void GlobalVariables()
		{
			System.out.println("");
			System.out.println("Set global Vars Database before we sttart");
			System.out.println("");
		}
		
		@AfterSuite
		public void GlobalVariablesReset()
		{
			System.out.println("");
			System.out.println("Set global Vars Database after we finish");
			System.out.println("");
		}
		

}

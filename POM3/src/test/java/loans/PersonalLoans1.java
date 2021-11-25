package loans;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class PersonalLoans1 
{
	
	@Test(groups ={"Smoke"})
	public void PersNewCust() throws InterruptedException
	{
		System.out.println("Hi New Personal loans 1 Customer ,We welcome you to Personal Loans");
		Thread.sleep(1000);
	}
	
	@Test(groups ={"Regression"})
	public void PersExCust2() throws InterruptedException
	{
		System.out.println("Hi Mrs Personal loans 1 Existing ,Good to have you back");
		Thread.sleep(1000);
	}
	
	@Test
	public void PersonalLoansFraudTest()
	{
			System.out.println("Hi Mrs Existing Personal loans 1  ,This is a Fraud incident");
			String expected = "Passed";
			String actual = "Stuff";					
			Reporter.log("Expected..............."+expected);
			Reporter.log("actual..............."+actual);
			
			Assert.assertTrue(false);
	}

}

package loans;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class PersonalLoans1 
{
	
	@Test(groups ={"Smoke"})
	public void PersNewCust()
	{
		System.out.println("Hi New Personal loans 1 Customer ,We welcome you to Personal Loans");
	}
	
	@Test(groups ={"Regression"})
	public void PersExCust2()
	{
		System.out.println("Hi Mrs Personal loans 1 Existing ,Good to have you back");
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

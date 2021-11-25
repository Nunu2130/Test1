package loans;

import org.testng.annotations.Test;

public class PersonalLoans2 
{
	
	@Test
	public void PersNewCust2()
	{
		System.out.println("Hi New Personal loans 2 Customer ,We welcome you to Personal Loans2");
	}
	
	@Test(groups ={"Regression"})
	public void ExistingCustomer2() throws InterruptedException
	{
		System.out.println("Hi Mr Existing Personal loans 2  ,Good to have you back");
		Thread.sleep(1000);
	}
	@Test
	public void PersonalLoans2FraudTest() throws InterruptedException
	{
			System.out.println("Hi Mrs Existing  Personal loans 2 ,This is a Fraud incident");
			Thread.sleep(1000);
	}
}

package loans;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class VehicleLoans 
{
	@Test(groups ={"Smoke"})
	public void VehicleNewCust()
	{
		System.out.println("Hi New Vehicle Loans Customer  ,We welcome you to Vehicle Loans");
	}
	
	@Test
	public void VehicleExistCust()
	{
		System.out.println("Hi Mr Existing Vehicle Loans ,Good to have you back");
	}
	@Test
	public void VehicleSpecialCust()
	{
		System.out.println("Hi Mr Existing Vehicle Loans ,You know you are our special customer");
	}
	@Test
	public void VehicleLoansFraudTest()
	{
			System.out.println("Hi Mrs Existing  Vehicle loans ,This is a Fraud incident");
	}
	
	@Parameters({"URL"})
	@Test
	public void VehicleLoansFraudTest(String URL)
	{
			System.out.println("Hi Mrs Existing  Vehicle loans ,This is a Fraud incident");
			System.out.println("THis is a URL Parameter"+ URL);
			
	}
	

	
	
	
}

package loans;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HomeLoanFraudulentTest
{
	//Data providers
	@Test (dataProvider = "getData")
	public void HomeLoan1FraudTest(String username , String lastname)
	{
		System.out.println("Home Loan1 Fraud Test");
		System.out.println(username + " "+lastname);
		
	}
	
	
	@DataProvider
	public Object [] getData()
	{
		//Iteration :
		//1st user name and pass - good credit history
		//2nd user name and pass - no credit history
		//3rd user name and pass - fraudulent credit history
		
		// define a multidimensional object array with 3 rows and 2 columns 
		// 3 rows for the number of test cases 
		//2 columns for the number of values passed in 
		
		Object[][] data =new Object [3][2];
		
		//1st set
		data[0][0] = "firstsetusername";
		data[0][1] = "firstsetusername";
		
		//2nd set
		data[1][0] = "firstsetusername";
		data[1][1] = "firstsetusername";
		
		//3rd set
		data[2][0] = "firstsetusername";
		data[2][1] = "firstsetusername";
				
		
		return data;
	}
	
	
	
}

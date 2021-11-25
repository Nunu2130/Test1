package ExamTests;

 
import org.testng.SkipException;
import org.testng.annotations.Test;

import Exam.ExamObj;
import frameWorkClasses.BasePage;

public class TC1AddToCart {
	
	ExamObj ex = new ExamObj(); 
	BasePage bp =  new BasePage();
	
	@Test
	public void GIVEN_ICLickDailyDeals_WHEN_ItemDoesNotHaveDeals_THEN_SkipTestCase() throws InterruptedException
	
		//1 Select at least 1 brand i.e Acer or Addis etc
		//2 Assert that there are more than 0 items displayed
		//3 (bonus) if less than 1 item skip the test case	

	{
			
			//GIVEN
				//I Click Daily Deals
					ex.clickGotIt();
					Thread.sleep(1000);
					ex.clickDailyDeals();
					Thread.sleep(1000);
												 
		   //WHEN
				//I Select a brand that doesn't have daily deals
		
				ex.captureBrand("gucci");
				
				String actBrandMSG = ex.BrandConfirmMsg();
				String expectedBrandMSG = "No results found for ";
					
			
			//THEN
				//I skip the test
		
				if (!(actBrandMSG==expectedBrandMSG))
				{
					System.out.println("");
					System.out.println("Test Skipped becuase brand does not have daily deals");	
					System.out.println("");
				throw new SkipException("Skipping the test case because brand is not found to have any daily deals" );	
				}
				
				Thread.sleep(1000);
				bp.cleanup();
				
				
	}
	

	}
	
	


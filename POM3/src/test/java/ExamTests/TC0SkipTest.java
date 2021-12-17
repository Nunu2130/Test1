
package ExamTests;

import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import examObj.ExamObj;
import frameWorkClasses.BasePage;

public class TC0SkipTest {

	// 1.Skip test on Daddy deals if the brand does not have deals 
	
	ExamObj ex = new ExamObj();
	BasePage bp = new BasePage();
	
	// Check for the Cookie button,Click on the it displayed

	@BeforeTest
	public void cookies() {
		ex.clickGotIt();
	}

	@Test
	public void GIVEN_ICLickDailyDeals_WHEN_ItemDoesNotHaveDeals_THEN_SkipTestCase() throws InterruptedException

	// 1 Select at least 1 brand i.e Acer or Addis etc
	// 2 Assert that there are more than 0 items displayed
	// 3 (bonus) if less than 1 item skip the test case

	{

		// GIVEN
		// I Click Daily Deals
		ex.clickDailyDeals();
		Thread.sleep(1000);

		// WHEN
		// I Select a brand that doesn't have daily deals

		ex.captureBrand("gucci");

		String actBrandMSG = ex.BrandConfirmMsg();
		String expectedBrandMSG = "No results found for ";

		// THEN
		// I skip the test

		if (!(actBrandMSG == expectedBrandMSG)) {

			throw new SkipException("Skipping the test case because brand is not found to have any daily deals");
		}

	}

	@AfterTest
	public void cleanup() {
		bp.cleanup();
	}
}

package loans;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import frameWorkClasses.ReadExcel;

public class ExamTestScript  
{
	
	
	ReadExcel rExcel = new ReadExcel();
	
	
	//GIT practice , Playing games with Funeka :)
	//Data providers
			@Test(dataProvider = "examData")
			public void ExamTestScriptTest(String Name , String Team, String Score)
			{
				System.out.println("Football Score Card");
				System.out.println(Name + " "+Team + " " +Score);
				System.out.println(" ");
			}
			
			
	@DataProvider(name = "examData")
	public Object[][] getDataFromExcel() throws IOException
	{
		 
		String excelDirectory = rExcel.getDataConfigProperties ("excelDataDir");
		Object[][] arrObj = rExcel.getExcelData(excelDirectory+"ExcelData.xlsx","Sheet1");
		
		return arrObj;
	}
	
}
